package com.cydm.money.mapper;

import com.cydm.money.model.User;

public interface UserMapper {
    int selectHeadcount();
    User selectLogin(String phone,String loginPassword);
    void update(User user);

    //查询是否有这个手机号
    int selectSame(String phone);

    void insert(User user);
}