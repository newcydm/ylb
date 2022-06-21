package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.mapper.BidInfoMapper;
import com.cydm.money.mapper.FinanceAccountMapper;
import com.cydm.money.mapper.IncomeRecordMapper;
import com.cydm.money.mapper.LoanInfoMapper;
import com.cydm.money.model.*;

import com.cydm.money.vo.Invest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = LoanInfoService.class,version = "1.0.0",loadbalance = "leastactive")
@Transactional(timeout = 60,readOnly = true)
public class LoanInfoServiceImpl implements LoanInfoService {
    @Autowired
    private LoanInfoMapper loanInfoMapper;

    @Autowired
    private BidInfoMapper bidInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private FinanceAccountMapper financeAccountMapper;

    @Autowired
    private BidInfoService bidInfoService;



    @Override
    public double queryAvgRate() {
        Double avgRate= (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVERAGE_RATE);

        if(avgRate==null){
            synchronized (this){
                avgRate= (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVERAGE_RATE);
                if(avgRate==null){
                    //从数据库查询
                    avgRate=loanInfoMapper.selectAvgRate();
                    redisTemplate.opsForValue().set(Constants.HISTORY_AVERAGE_RATE,avgRate,1, TimeUnit.DAYS);
                }
            }
        }
        //先从缓存读取
        return avgRate;
    }

    @Override
    public Map<String,Object> queryByProductType(int page, int pages, int type) {

       //产品
        List<LoanInfo> loanInfoList = null;


        if(!redisTemplate.hasKey("products"+type)){

            synchronized (this){

                if(!redisTemplate.hasKey("products"+type)){

                    loanInfoList=loanInfoMapper.selectByProductType(type);

                    if(loanInfoList.size()==0){//防穿透
                        redisTemplate.opsForValue().set("products"+type,"");
                        return null;
                    }

                    loanInfoList.forEach(x->redisTemplate.opsForHash().put("products"+type,x.getId(),x));


                    redisTemplate.expire("products"+type,15,TimeUnit.MINUTES);

                }

            }

        }else{
            if(!redisTemplate.type("products"+type).equals(DataType.HASH)){
                return null;
            }

            loanInfoList=redisTemplate.opsForHash().values("products"+type);
        }

        Map<String,Object> map=new HashMap<>();
        map.put("rows",loanInfoList.size());


        List<LoanInfo> list=new ArrayList<>();
        for (int i = (page - 1) * pages; i <(loanInfoList.size()<pages*page?loanInfoList.size():pages*page); i++) {
            list.add(loanInfoList.get(i));
        }

        loanInfoList.clear();
        loanInfoList=list;


        map.put("products",loanInfoList);

        return map;


    }

    @Override//只从缓存查询
    public LoanInfo queryById(int type,int productId) {
        return(LoanInfo)redisTemplate.opsForHash().get("products"+type,productId);
    }



    //投资商品
    @Transactional(timeout = 60)
    public boolean investment(int productId, int type, double money, int id,String phone,double userMoney) {
        //判断该商品是否满标
        //redis缓存
        LoanInfo loanInfo = (LoanInfo) redisTemplate.opsForHash().get("products" + type, productId);

        if(loanInfo.getLeftProductMoney()-money<0){
            return false;
        }

        if(loanInfo==null||loanInfo.getProductStatus()!=0){
            return false;
        }

        while (true){
            loanInfo=(LoanInfo) redisTemplate.opsForHash().get("products" + type, productId);

            if(loanInfo.getProductStatus()!=0||loanInfo.getLeftProductMoney()-money<0){
                return false;
            }
            Date date=new Date();
            //修改产品所剩余额和状态，乐观锁
            loanInfo.setLeftProductMoney(loanInfo.getLeftProductMoney()-money);
            if(loanInfo.getLeftProductMoney()-money==0){
                loanInfo.setProductFullTime(date);
                loanInfo.setProductStatus(1);
            }

            int update = loanInfoMapper.update(loanInfo);

            if(update==0) continue;
            loanInfo.setVersion(loanInfo.getVersion()+1);
            //修改成功
            redisTemplate.opsForHash().put("products" + type,productId,loanInfo);

            //修改用户金额
            FinanceAccount financeAccount=new FinanceAccount();
            financeAccount.setUid(id);
            financeAccount.setAvailableMoney(userMoney-money);
           financeAccountMapper.update(financeAccount);
            //增加这个产品投资记录

            BidInfo bidInfo=new BidInfo();
            bidInfo.setLoanId(productId);
            bidInfo.setUid(id+"");
            bidInfo.setBidTime(date);
            bidInfo.setBidMoney(money);
            bidInfoMapper.insert(bidInfo);

            bidInfo.setUid(phone);
            //产品投资记录增加到redis
            redisTemplate.opsForHash().put("bidInfos-"+productId,bidInfo.getId(),bidInfo);

            //修改排行榜
            redisTemplate.opsForZSet().incrementScore(Constants.INVEST_TOP,phone,money);

            //增加平台总投资金额
            stringRedisTemplate.opsForValue().increment(Constants.ALL_BID_MONEY,money);

            //修改缓存的当前产品
            redisTemplate.opsForHash().put("products" + type, productId,loanInfo);

            //增加用户投资记录
            Invest invest=new Invest();
            invest.setTime(date);
            invest.setMoney(money);
            invest.setProductName(loanInfo.getProductName());
            invest.setStatus(1);

            if(!redisTemplate.hasKey(UserConstants.INVEST+id)){
                bidInfoService.queryByUserInfoAll(0,0,id);
            }

            redisTemplate.opsForHash().put(UserConstants.INVEST+id,invest.hashCode(),invest);



            return true;
        }


    }

}
