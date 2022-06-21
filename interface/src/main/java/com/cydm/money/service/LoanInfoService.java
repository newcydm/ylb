package com.cydm.money.service;


import com.cydm.money.model.LoanInfo;

import java.util.Map;

public interface LoanInfoService {
    double queryAvgRate();
    Map<String,Object> queryByProductType(int page, int pages, int type);

    LoanInfo queryById(int type,int productId);

    boolean investment(int productId,int type, double money,int id,String phone,double userMoney);
}
