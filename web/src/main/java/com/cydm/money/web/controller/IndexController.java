package com.cydm.money.web.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.cydm.money.common.constant.Constants;

import com.cydm.money.service.BidInfoService;
import com.cydm.money.service.LoanInfoService;
import com.cydm.money.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController{
    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false)
    private LoanInfoService loanInfoService;

    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false)
    private BidInfoService bidInfoService;

    //首页
    @GetMapping("/index")
    public String index(Model model){
        //年利率
        model.addAttribute(Constants.HISTORY_AVERAGE_RATE,loanInfoService.queryAvgRate());
        //平台注册总人数
        model.addAttribute(Constants.ALL_USER_COUNT,userService.queryHeadcount());
        //平台积累投资总金额
        model.addAttribute(Constants.ALL_BID_MONEY,bidInfoService.queryTotalMoney());
        //新手宝一个
        model.addAttribute("product0",loanInfoService.queryByProductType(1,1,Constants.PRODUCT_TYPE_X).get("products"));
        //优先类四个
        model.addAttribute("product1",loanInfoService.queryByProductType(1,4,Constants.PRODUCT_TYPE_U).get("products"));
        //散标八个
        model.addAttribute("product2",loanInfoService.queryByProductType(1,8,Constants.PRODUCT_TYPE_S).get("products"));
        return "index";
    }

}
