package com.cydm.money.service;

import com.cydm.money.model.BidInfo;
import com.cydm.money.vo.TopRank;

import java.util.List;
import java.util.Map;

public interface BidInfoService {
    int queryTotalMoney();
    List<TopRank> queryTopRank();
    List<BidInfo> queryByLoanId(int id);
    Map<String,Object> queryByUserInfoAll(int page,int pages,int id);


}
