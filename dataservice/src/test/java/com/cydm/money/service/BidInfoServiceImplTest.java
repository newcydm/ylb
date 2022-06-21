package com.cydm.money.service;

import com.cydm.money.model.BidInfo;
import com.cydm.money.vo.Invest;
import com.cydm.money.vo.TopRank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
class BidInfoServiceImplTest {
    @Autowired
    private BidInfoService bidInfoService;
    @Test
    void s(){
        for (TopRank topRank : bidInfoService.queryTopRank()) {
            System.out.println(topRank);
        }

    }

    @Test
    void queryTopRank() {
        List<BidInfo> bidInfoList = bidInfoService.queryByLoanId(1310699);

        for (BidInfo bidInfo : bidInfoList) {
            System.out.println(bidInfo);
        }
    }
}