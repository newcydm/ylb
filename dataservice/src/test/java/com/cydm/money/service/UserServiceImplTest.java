package com.cydm.money.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    void t(){
        System.out.println(userService.querySame("1370000"));
    }

    @Test
    void sendVerificationCode()  {
        boolean b = userService.sendVerificationCode("17607088005");

        System.out.println(b);

    }
    @Test
    void s(){

    }
}