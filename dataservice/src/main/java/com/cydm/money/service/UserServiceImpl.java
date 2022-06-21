package com.cydm.money.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.common.util.SendCodeUtil;
import com.cydm.money.mapper.FinanceAccountMapper;
import com.cydm.money.mapper.UserMapper;
import com.cydm.money.model.FinanceAccount;
import com.cydm.money.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = UserService.class,version = "1.0.0",loadbalance = "leastactive")
@Transactional(timeout = 60)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FinanceAccountMapper financeAccountMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${wj.key}")
    private String wjKey;

    @Value("${wj.uid}")
    private String uid;

    @Value("${wx.key}")
    private String wxKey;

    @Transactional(timeout = 60,readOnly = true)
    public int queryHeadcount() {
       Integer headcount = null;
       if(!stringRedisTemplate.hasKey(Constants.ALL_USER_COUNT)){
           synchronized (this){//双重判断
               if(!stringRedisTemplate.hasKey(Constants.ALL_USER_COUNT)){
                   headcount=userMapper.selectHeadcount();
                   stringRedisTemplate.opsForValue().set(Constants.ALL_USER_COUNT,headcount+"",1, TimeUnit.DAYS);
               }
           }
       }else{
           headcount=Integer.parseInt(stringRedisTemplate.opsForValue().get(Constants.ALL_USER_COUNT))    ;
       }
        return headcount;
    }

    @Transactional(timeout = 60,readOnly = true)
    public User queryLogin(String phone, String loginPassword) {
        return userMapper.selectLogin(phone,loginPassword);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    @Transactional(timeout = 60,readOnly = true)
    public boolean querySame(String phone) {
        return userMapper.selectSame(phone)>0;
    }

    @Override
    public boolean sendVerificationCode(String phone) {
        String code=RandomStringUtils.randomNumeric(4);
        redisTemplate.opsForValue().set(UserConstants.LOGIN_CODE+phone,code,5,TimeUnit.MINUTES);
        Map<String,String> map=new HashMap<>();
        map.put("Uid",uid);
        map.put("Key",wjKey);
        map.put("smsMob",phone);
        map.put("smsText","【网建】您的验证码是："+ code);
        try {
            String result = SendCodeUtil.doGet("http://utf8.api.smschinese.cn/",map);
            if(Integer.parseInt(result)>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean verifyVerificationCode(String phone,String messageCode) {
        String code= (String) redisTemplate.opsForValue().get(UserConstants.LOGIN_CODE+phone);
        if(code.equals(messageCode.trim())){
            return true;
        }
        return false;
    }

    @Override
    public User register(String phone, String loginPassword) {
        //移除redis缓存的验证码
        redisTemplate.delete(UserConstants.LOGIN_CODE+phone);
        //增加用户
        Date date=new Date();
        User user=new User();
        user.setAddTime(date);
        user.setPhone(phone);
        user.setLoginPassword(loginPassword);
        user.setLastLoginTime(date);
        userMapper.insert(user);
        //初始化用户资金账号
        FinanceAccount fa = new FinanceAccount();
        fa.setAvailableMoney(0d);
        fa.setUid(user.getId());
        financeAccountMapper.insert(fa);
        //增加平台总人数

        return user;
    }

    @Override
    public boolean realNameAuthentication(String name, String idCard) {
        Map map=new HashMap();
        map.put("name",name);
        map.put("id",idCard);
        map.put("appkey",wxKey);
        try {
            String result = SendCodeUtil.doPost("https://way.jd.com/fegine/idCert", map);
            String status = JSON.parseObject(JSON.parseObject(result).getString("result")).
                    getString("status");
            if(status.equals("01")){
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }

    }
}
