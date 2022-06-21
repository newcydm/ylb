package com.cydm.money.model;

import java.io.Serializable;

public class FinanceAccount implements Serializable {
    private static final long serialVersionUID = 7222017384253173694L;
    private Integer id;

    private Integer uid;

    private Double availableMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(Double availableMoney) {
        this.availableMoney = availableMoney;
    }
}