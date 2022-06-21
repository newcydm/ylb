package com.cydm.money.web.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cydm.money.common.constant.Constants;

import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.model.LoanInfo;
import com.cydm.money.model.User;
import com.cydm.money.service.BidInfoService;
import com.cydm.money.service.FinanceAccountService;
import com.cydm.money.service.LoanInfoService;
import com.cydm.money.service.UserService;
import com.cydm.money.vo.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/loan")
public class LoanController{
    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false)
    private LoanInfoService loanInfoService;

    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false)
    private BidInfoService bidInfoService;


    //产品页
    @GetMapping("/loan")
    public String loan(Integer page,Integer pages,Integer ptype, Model model){
        page=page==null?1:page;
        pages=pages==null?6:pages;
        ptype=ptype==null?1:ptype;
        Map<String, Object> map = loanInfoService.queryByProductType(page, pages, ptype);
        //总数据
        Integer rows= (Integer) map.get("rows");

        //总页数
        model.addAttribute("pageSize",rows%pages==0?rows/page:rows/pages+1);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute(Constants.INVEST_TOP,bidInfoService.queryTopRank());

        model.addAttribute("products",map.get("products"));
        return "loan";
    }

    //产品
    @GetMapping("/loanInfo")
    public String loanInfo(int productType,int productId,Model model){
        LoanInfo loanInfo = loanInfoService.queryById(productType, productId);
        model.addAttribute("info",loanInfo);
        model.addAttribute("bidInfo",bidInfoService.queryByLoanId(productId));
        return "loanInfo";
    }

    //投资产品
    @PostMapping("/loanInfo")
    @ResponseBody
    public ApiResult loanInfoOn(int productId,int type,double money,HttpSession session) {
        //判断余额是否充足
        Double balance = (Double) session.getAttribute(UserConstants.BALANCE);
        if(balance<money){
            return new ApiResult(201,"余额不足",null);
        }

        //判断是否实名认证
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        if(user.getName()==null||user.getIdCard()==null){
            return new ApiResult(201,"请实名认证",null);
        }

        if(loanInfoService.investment(productId,type,money,user.getId(),user.getPhone(),balance)){
            session.setAttribute(UserConstants.BALANCE,balance-money);
            return new ApiResult(200,"投资成功",null);
        }

        return new ApiResult(201,"投资失败，请稍后再试",null);

    }







}
