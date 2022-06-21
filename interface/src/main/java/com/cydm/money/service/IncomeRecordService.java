package com.cydm.money.service;

import java.util.Map;

public interface IncomeRecordService {
    Map<String,Object> queryEarnings(int page, int pages, int id);
}
