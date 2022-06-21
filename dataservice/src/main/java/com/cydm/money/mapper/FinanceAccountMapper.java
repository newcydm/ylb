package com.cydm.money.mapper;

import com.cydm.money.model.FinanceAccount;

public interface FinanceAccountMapper {
    double selectByUser(int id);

    void insert(FinanceAccount fa);

    void update(FinanceAccount financeAccount);

    void updateReturnedMoney(FinanceAccount financeAccount);
}