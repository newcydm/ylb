package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cydm.money.common.config.AlipayConfig;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.mapper.FinanceAccountMapper;
import com.cydm.money.mapper.RechargeRecordMapper;
import com.cydm.money.model.FinanceAccount;
import com.cydm.money.model.RechargeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = RechargeRecordService.class,version = "1.0.0",loadbalance = "leastactive")
@Transactional(timeout = 60)
public class RechargeRecordServiceImpl implements RechargeRecordService {
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private FinanceAccountMapper financeAccountMapper;
    @Transactional(timeout = 60,readOnly = true)
    public Map<String,Object> queryRechargeAll(int page,int pages,int id) {
        List<RechargeRecord> list= null;

        if(!redisTemplate.hasKey(UserConstants.RECHARGES+id)){

            list=rechargeRecordMapper.selectRechargeAll(id);
            if(list.size()==0){
                redisTemplate.opsForValue().set(UserConstants.RECHARGES +id,"");
            }

            list.forEach(x->
                    redisTemplate.opsForHash().put(UserConstants.RECHARGES +id,x.getId(),x)
            );
            redisTemplate.expire(UserConstants.RECHARGES +id,5,TimeUnit.MINUTES);

        }else{
            if(redisTemplate.type(UserConstants.RECHARGES +id).equals(DataType.HASH)){
                list=(List<RechargeRecord>) redisTemplate.opsForHash().values(UserConstants.RECHARGES +id);
            }else{
                list=new ArrayList<>();
            }
        }


        Collections.sort(list, new Comparator<RechargeRecord>() {
            @Override
            public int compare(RechargeRecord o1, RechargeRecord o2) {
                return o2.getRechargeTime().compareTo(o1.getRechargeTime());
            }
        });

        //list分页
        Map<String,Object> map=new HashMap<>();
        map.put("rows",list.size());

        List<RechargeRecord> list1=new ArrayList<>();

        for (int i = (page - 1) * pages; i <(list.size()<pages*page?list.size():pages*page); i++) {
            list1.add(list.get(i));
        }



        list.clear();
        list=list1;

        map.put(UserConstants.RECHARGES ,list);

        return map;
    }

    /**
     * 创建充值订单
     * @param rechargeRecord 订单
     */
    public void recharge(RechargeRecord rechargeRecord) {
        rechargeRecordMapper.insert(rechargeRecord);
    }

    /**
     * 支付成功
     * @param r 订单
     */
    @Override
    public void paymentSuccess(RechargeRecord r) {
        //修改用户小金库
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setUid(r.getUid());
        financeAccount.setAvailableMoney(r.getRechargeMoney());
        financeAccountMapper.updateReturnedMoney(financeAccount);

        //修改订单状态
        rechargeRecordMapper.updateStatus(1,r.getRechargeNo());

    }

    /**
     * 支付失败
     * @param r 订单
     */
    public void paymentFailure(RechargeRecord r){
        //修改订单状态
        rechargeRecordMapper.updateStatus(2,r.getRechargeNo());
    }
}
