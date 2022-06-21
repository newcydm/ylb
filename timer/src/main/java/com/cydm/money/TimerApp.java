package com.cydm.money;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;

@SpringBootApplication
@EnableScheduling
@EnableDubboConfiguration
public class TimerApp {
    public static void main(String[] args) {
        SpringApplication.run(TimerApp.class,args);
    }
}
