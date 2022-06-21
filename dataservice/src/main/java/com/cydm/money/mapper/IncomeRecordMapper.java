package com.cydm.money.mapper;


import com.cydm.money.model.IncomeRecord;
import com.cydm.money.vo.Earnings;

import java.util.Date;
import java.util.List;

public interface IncomeRecordMapper {
    List<Earnings> selectEarnings(int id);
    List<IncomeRecord> selectNotRecord(Integer status);

    void update(IncomeRecord incomeRecord);

    void insert(IncomeRecord incomeRecord);
}