package com.cydm.money.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BidInfoMapperTest {
    @Autowired
    private BidInfoMapper bidInfoMapper;
    @Test
    void t(){
        System.out.println(bidInfoMapper.selectTotalMoney());
    }

}