package com.cydm.money.mapper;

import com.cydm.money.model.RechargeRecord;

import java.util.List;

public interface RechargeRecordMapper {
    List<RechargeRecord> selectRechargeAll(int id);

    void insert(RechargeRecord rechargeRecord);

    List<RechargeRecord> selectStatus(int i);

    void update(RechargeRecord rechargeRecord);

    void updateStatus(int status, String trade_status);
}