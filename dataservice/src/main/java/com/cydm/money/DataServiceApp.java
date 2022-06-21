package com.cydm.money;


import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableDubboConfiguration
@EnableAsync
@MapperScan("com.cydm.money.mapper")
public class DataServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(DataServiceApp.class,args);
    }
}
