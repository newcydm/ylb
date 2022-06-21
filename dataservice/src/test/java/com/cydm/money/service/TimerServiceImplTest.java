package com.cydm.money.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TimerServiceImplTest {
    @Autowired
    private TimerService timerService;

    @Test
    void t(){
        timerService.rechargeResult();
    }


}