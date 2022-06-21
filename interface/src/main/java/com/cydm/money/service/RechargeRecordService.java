package com.cydm.money.service;

import com.cydm.money.model.RechargeRecord;

import java.util.Map;

public interface RechargeRecordService {
    Map<String,Object> queryRechargeAll(int page, int pages, int id);

    //增加订单
    void recharge(RechargeRecord rechargeRecord);
    //支付成功
    void paymentSuccess(RechargeRecord rechargeRecord);
    //支付失败
    void paymentFailure(RechargeRecord rechargeRecord);
}
