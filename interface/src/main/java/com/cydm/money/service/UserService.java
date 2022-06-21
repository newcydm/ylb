package com.cydm.money.service;

import com.cydm.money.model.User;

public interface UserService {
    int queryHeadcount();
    User queryLogin(String phone, String loginPassword);
    void update(User user);

    boolean querySame(String phone);

    boolean sendVerificationCode(String phone);

    boolean verifyVerificationCode(String phone,String messageCode);

    User register(String phone, String loginPassword);

    boolean realNameAuthentication(String name,String idCard);

}
