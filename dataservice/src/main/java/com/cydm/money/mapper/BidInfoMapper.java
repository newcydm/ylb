package com.cydm.money.mapper;


import com.cydm.money.model.BidInfo;
import com.cydm.money.vo.Invest;
import com.cydm.money.vo.TopRank;


import java.util.List;

public interface BidInfoMapper {
    int selectTotalMoney();
    List<TopRank> selectTopRank();
    List<BidInfo> selectByLoanId(int id);
    List<Invest> selectByUserInfoAll(int id);

    void insert(BidInfo bidInfo);

    List<BidInfo> selectById(Integer id);
}