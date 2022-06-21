package com.cydm.money.mapper;


import com.cydm.money.model.LoanInfo;

import java.util.List;

public interface LoanInfoMapper {
    double selectAvgRate();
    List<LoanInfo> selectByProductType(int type);

    int update(LoanInfo loanInfo);

    List<LoanInfo> selectFulScaleAll();

    void updateStatus(LoanInfo loanInfo);
}