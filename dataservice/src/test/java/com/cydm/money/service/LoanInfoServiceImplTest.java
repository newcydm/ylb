package com.cydm.money.service;

import com.cydm.money.model.LoanInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoanInfoServiceImplTest {
    @Autowired
    private LoanInfoService loanInfoService;

    @Test
    void queryByProductType() {
        Map<String, Object> map = loanInfoService.queryByProductType(1, 4, 2);
        if(map==null){
            System.out.println("无");
            return;
        }
        System.out.println(map.get("rows"));
        List<LoanInfo> list= (List<LoanInfo>) map.get("products");
        list.forEach(x-> System.out.println(x));


    }
    @Test
    void q(){
        System.out.println(loanInfoService.queryById(0,1310699));
    }
}