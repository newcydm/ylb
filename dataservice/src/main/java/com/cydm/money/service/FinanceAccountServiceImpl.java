package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cydm.money.mapper.FinanceAccountMapper;
import com.cydm.money.model.FinanceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = FinanceAccountService.class,version = "1.0.0",loadbalance = "leastactive")
public class FinanceAccountServiceImpl implements FinanceAccountService {
    @Autowired
    private FinanceAccountMapper financeAccountMapper;
    @Override
    public double queryByUser(int id) {
        return financeAccountMapper.selectByUser(id);
    }

    @Override
    public void update(FinanceAccount financeAccount) {
        financeAccountMapper.updateReturnedMoney(financeAccount);
    }
}
