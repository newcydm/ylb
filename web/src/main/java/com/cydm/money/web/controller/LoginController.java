package com.cydm.money.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.model.User;
import com.cydm.money.service.BidInfoService;
import com.cydm.money.service.FinanceAccountService;
import com.cydm.money.service.UserService;
import com.cydm.money.vo.ApiResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("/loan")
public class LoginController {
    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false)
    private UserService userService;

    @Reference(interfaceClass = FinanceAccountService.class,version = "1.0.0",check = false)
    private FinanceAccountService financeAccountService;

    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false)
    private BidInfoService bidInfoService;
    //登录界面
    @GetMapping("/page/login")
    public String login(Model model){
        model.addAttribute(Constants.ALL_USER_COUNT,userService.queryHeadcount());
        model.addAttribute(Constants.ALL_BID_MONEY,bidInfoService.queryTotalMoney());
        return "login";
    }

    //退出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:../index";
    }

    //登录
    @PostMapping("/page/login")
    @ResponseBody
    public ApiResult doLogin(String phone, String loginPassword, String code, HttpSession session){
        String co=(String)session.getAttribute(UserConstants.LOGIN_CAPTCHA);
        if(!co.equalsIgnoreCase(code)){//判断验证码
            return new ApiResult(201,"验证码错误",null);
        }

        User user = userService.queryLogin(phone, loginPassword);

        if(user==null){
            return new ApiResult(201,"账号或密码错误",null);
        }



        session.setAttribute(UserConstants.BALANCE,financeAccountService.queryByUser(user.getId()));
        session.setAttribute(Constants.SESSION_USER,user);


        User user1=new User();
        user1.setLastLoginTime(new Date());
        user1.setId(user.getId());
        userService.update(user1);



        return new ApiResult(200,"登录成功",null);
    }



    //图形验证码
    @GetMapping("/jcaptcha/captcha")
    public void Logincaptcha(HttpServletResponse resp, HttpSession session) throws IOException {
        BufferedImage image=new BufferedImage(79, 36, BufferedImage.TYPE_BYTE_BINARY);

        //编辑图像
        //获取绘图对象
        Graphics g=image.getGraphics();

        //设置字体颜色
        g.setColor(Color.white);

        //设置字体
        g.setFont(new Font("SimSong",Font.ITALIC,26));

        //绘制字符串；
        String text="";
        for(int i=0;i<4;i++) {
            //*10不是乘十，而是确定随机数的范围。从0开始。
            text +=(int) (Math.random()*10);
        }

        //字符串输出内容，水平起始坐标，垂直起始坐标。
        g.drawString(text, 17, 24);

        session.setAttribute(UserConstants.LOGIN_CAPTCHA,text);

        //输出图像
        ImageIO.write(image, "png", resp.getOutputStream());


    }
}
