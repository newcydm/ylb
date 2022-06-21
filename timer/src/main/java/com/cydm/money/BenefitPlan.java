package com.cydm.money;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cydm.money.service.TimerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BenefitPlan {
    @Reference(interfaceClass = TimerService.class,version = "1.0.0",check = false)
    private TimerService timerService;

    @Scheduled(cron = "0 45 1 * * ?")//每天凌晨一点45执行该代码
    public void revenuePlan(){
        timerService.revenuePlan();
    }

    @Scheduled(cron = "0 0 2 * * ?")//每天凌晨二点执行该代码
    public void returnedMoney(){
        timerService.returnedMoney();
    }

    @Scheduled(fixedRate = 1000*60*120)//每两个小时执行一次
    public void recharge(){
        timerService.rechargeResult();
    }
}
