package com.cydm.money.service;

import com.cydm.money.model.RechargeRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RechargeRecordServiceImplTest {
    @Autowired
    private RechargeRecordService rechargeRecordService;
    @Test
    void t(){
        rechargeRecordService.queryRechargeAll(1, 5, 23);


    }


}