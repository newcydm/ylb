package com.cydm.money.service;

import com.cydm.money.model.FinanceAccount;

public interface FinanceAccountService {
    double queryByUser(int id);

    void update(FinanceAccount financeAccount);
}
