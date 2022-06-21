package com.cydm.money.config;

import com.cydm.money.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns={
                "/loan/**"
        };
        String[] excludePathPatterns={
                "/loan/loan",//产品详情页
                "/loan/page/login",//登录
                "/loan/page/register",//注册
                "/loan/jcaptcha/captcha",//登录验证码
                "/loan/loanInfo",//产品投资页
                "/loan/api/phone",//注册api
                "/loan/sendCode"//发送注册验证码


        };
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
