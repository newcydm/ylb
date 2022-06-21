package com.cydm.money.vo;

import java.io.Serializable;

public class TopRank implements Serializable {
    private static final long serialVersionUID = -4421656270909884853L;
    private String phone;
    private double money;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TopRank{" +
                "phone='" + phone + '\'' +
                ", money=" + money +
                '}';
    }
}
