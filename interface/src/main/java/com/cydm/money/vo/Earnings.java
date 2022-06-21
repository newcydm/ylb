package com.cydm.money.vo;

import java.io.Serializable;
import java.util.Date;

public class Earnings implements Serializable {
    private String productName;
    private double BidMoney;
    private Date date;
    private double incomeMoney;
    private int status;
    public Earnings(){}

    public Earnings(String productName, double bidMoney, Date date, double incomeMoney, int status) {
        this.productName = productName;
        BidMoney = bidMoney;
        this.date = date;
        this.incomeMoney = incomeMoney;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBidMoney() {
        return BidMoney;
    }

    public void setBidMoney(double bidMoney) {
        BidMoney = bidMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
