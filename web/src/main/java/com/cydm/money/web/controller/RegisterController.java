package com.cydm.money.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.model.User;
import com.cydm.money.service.FinanceAccountService;
import com.cydm.money.service.UserService;
import com.cydm.money.vo.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/loan")
public class RegisterController {
    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @Reference(interfaceClass = FinanceAccountService.class,version = "1.0.0",check = false)
    private FinanceAccountService financeAccountService;

    //注册界面
    @GetMapping("/page/register")
    public String register(){
        return "register";
    }

    //实名认证界面
    @GetMapping("/page/realName")
    public String realName(){
        return "realName";
    }

    //实名认证
    @PostMapping("/page/realName")
    @ResponseBody
    public ApiResult realNameOn(String realName,String idCard,String captcha,HttpSession session){
        String code= (String) session.getAttribute(UserConstants.LOGIN_CAPTCHA);

        if(!code.equals(captcha)){
            return new ApiResult(201,"验证码错误",null);
        }

        if(userService.realNameAuthentication(realName,idCard)){
            return new ApiResult(202,"实名认证不通过",null);
        }

        //增加实名认证
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        user.setName(realName);
        user.setIdCard(idCard);
        userService.update(user);
        return new ApiResult(200,"实名认证通过",null);
    }

    //验证手机号，没有返回200
    @PostMapping("/api/phone")
    public @ResponseBody ApiResult apiPhone(String phone){
        if(userService.querySame(phone)){
            return new ApiResult(201,null,null);
        }
        return new ApiResult(200,null,null);
    }


    //发送验证码
    @PostMapping("/sendCode")
    public @ResponseBody ApiResult sendCode(String phone){
        if(userService.sendVerificationCode(phone)){
            return new ApiResult(200,null,null);
        }
        return new ApiResult(201,null,null);
    }

    //注册
    @PostMapping("/page/register")
    public @ResponseBody ApiResult registerSend(String phone, String loginPassword, String messageCode, HttpSession session){

        if(!userService.verifyVerificationCode(phone,messageCode)){
            return new ApiResult(201,"验证码错误",null);
        }
        //注册用户
        User user=userService.register(phone,loginPassword);
        session.setAttribute(Constants.SESSION_USER,user);
        session.setAttribute(UserConstants.BALANCE,financeAccountService.queryByUser(user.getId()));
        return new ApiResult(200,null,null);

    }


}
