package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.mapper.IncomeRecordMapper;

import com.cydm.money.vo.Earnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@Transactional(timeout = 60)
@Service(interfaceClass = IncomeRecordService.class,version = "1.0.0",loadbalance = "leastactive")
public class IncomeRecordServiceImpl implements IncomeRecordService {

    @Autowired
    private IncomeRecordMapper incomeRecordMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(timeout = 60,readOnly = true)
    public Map<String,Object> queryEarnings(int page, int pages, int id) {

        List<Earnings> incomeRecordList= null;

        if(!redisTemplate.hasKey("earnings-"+id)){

            incomeRecordList=incomeRecordMapper.selectEarnings(id);
            if(incomeRecordList.size()==0){
                redisTemplate.opsForValue().set(UserConstants.EARNINGS +id,"");
            }

            incomeRecordList.forEach(x->
                    redisTemplate.opsForHash().put(UserConstants.EARNINGS+id,x.hashCode(),x)
                    );
            redisTemplate.expire(UserConstants.EARNINGS+id,1,TimeUnit.HOURS);

        }else{
            if(redisTemplate.type(UserConstants.EARNINGS+id).equals(DataType.HASH)){
                incomeRecordList=(List<Earnings>) redisTemplate.opsForHash().values(UserConstants.EARNINGS+id);
            }else{
                incomeRecordList=new ArrayList<>();
            }

        }
        Map<String,Object> map=new HashMap<>();
        map.put("rows",incomeRecordList.size());

        Collections.sort(incomeRecordList, new Comparator<Earnings>() {
            @Override
            public int compare(Earnings o1, Earnings o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        List<Earnings> list=new ArrayList<>();
        for (int i = (page - 1) * pages; i <(incomeRecordList.size()<pages*page?incomeRecordList.size():pages*page); i++) {
            list.add(incomeRecordList.get(i));
        }

        incomeRecordList.clear();
        incomeRecordList=list;
        map.put(UserConstants.EARNINGS,incomeRecordList);

        return map;
    }
}
