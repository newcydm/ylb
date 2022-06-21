package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.mapper.BidInfoMapper;
import com.cydm.money.model.BidInfo;
import com.cydm.money.vo.Invest;
import com.cydm.money.vo.TopRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = BidInfoService.class,version = "1.0.0",loadbalance = "leastactive")
@Transactional(timeout = 60,readOnly = true)
public class BidInfoServiceImpl implements BidInfoService {
    @Autowired
    private BidInfoMapper bidInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public int queryTotalMoney() {
        Integer totalMoney= null;

        if(!stringRedisTemplate.hasKey(Constants.ALL_BID_MONEY)){
            synchronized (this){
                if(!stringRedisTemplate.hasKey(Constants.ALL_BID_MONEY)){
                    totalMoney=bidInfoMapper.selectTotalMoney();
                    stringRedisTemplate.opsForValue().set(Constants.ALL_BID_MONEY,totalMoney+"",1, TimeUnit.DAYS);
                }
            }
        }else{
            totalMoney=Integer.parseInt( stringRedisTemplate.opsForValue().get(Constants.ALL_BID_MONEY));
        }
        return totalMoney;
    }

    @Override
    public List<TopRank> queryTopRank() {
        List<TopRank> topRankList = null;

        if(!redisTemplate.hasKey(Constants.INVEST_TOP)){//判断是否有这个键
            synchronized (this){

                if(!redisTemplate.hasKey(Constants.INVEST_TOP)){
                    topRankList= bidInfoMapper.selectTopRank();
                    for (TopRank topRank : topRankList) {
                        redisTemplate.opsForZSet().add(Constants.INVEST_TOP,topRank.getPhone(),topRank.getMoney());
                    }
                }
            }
        }else{
            topRankList=new ArrayList<>();

            Set<ZSetOperations.TypedTuple<String>> set=redisTemplate.opsForZSet().reverseRangeWithScores(Constants.INVEST_TOP, 0, -1);

            for (ZSetOperations.TypedTuple<String> zt : set) {
                TopRank topRank=new TopRank();
                topRank.setMoney(zt.getScore());
                topRank.setPhone(zt.getValue());
                topRankList.add(topRank);
            }

            
        }
        return topRankList;
    }

    @Override
    public List<BidInfo> queryByLoanId(int id) {
        List<BidInfo> bidInfoList=null;
        if(!redisTemplate.hasKey("bidInfos-"+id)){
            synchronized (this){
                if(!redisTemplate.hasKey("bidInfos-"+id)){
                    bidInfoList=bidInfoMapper.selectByLoanId(id);
                    for (BidInfo bidInfo : bidInfoList) {
                        redisTemplate.opsForHash().put(
                                "bidInfos-"+id,bidInfo.getId(),bidInfo);
                    }
                }else{
                    bidInfoList=(List<BidInfo>)redisTemplate.opsForHash().values("bidInfos-"+id);
                }
            }
        }else{
            bidInfoList=(List<BidInfo>)redisTemplate.opsForHash().values("bidInfos-"+id);
        }
        Collections.sort(bidInfoList, new Comparator<BidInfo>() {
            @Override
            public int compare(BidInfo o1, BidInfo o2) {
                return o2.getBidTime().compareTo(o1.getBidTime());
            }
        });
        return bidInfoList;
    }

    @Override
    public Map<String,Object> queryByUserInfoAll(int page,int pages,int id) {
        List<Invest> investList= null;

        if(!redisTemplate.hasKey(UserConstants.INVEST+id)){

            investList=bidInfoMapper.selectByUserInfoAll(id);

            if(investList.size()==0){
                redisTemplate.opsForValue().set(UserConstants.INVEST+id,"");
            }

            for (Invest x : investList) {
                redisTemplate.opsForHash().put(UserConstants.INVEST+id,x.hashCode(),x);
            }



            redisTemplate.expire(UserConstants.INVEST+id,1,TimeUnit.HOURS);

        }else{
            if(redisTemplate.type(UserConstants.INVEST+id).equals(DataType.HASH)){
                investList=(List<Invest>) redisTemplate.opsForHash().values(UserConstants.INVEST+id);
            }else{
                investList=new ArrayList<>();
            }
        }
        Collections.sort(investList, new Comparator<Invest>() {
            @Override
            public int compare(Invest o1, Invest o2) {
                return o2.getTime().compareTo(o1.getTime());
            }
        });

        Map<String,Object> map=new HashMap<>();
        map.put("rows",investList.size());

        List<Invest> list=new ArrayList<>();


        for (int i = (page - 1) * pages; i <(investList.size()<pages*page?investList.size():pages*page); i++) {
            list.add(investList.get(i));
        }



        investList.clear();
        investList=list;
        map.put(UserConstants.INVEST,investList);
        return map;
    }


}
