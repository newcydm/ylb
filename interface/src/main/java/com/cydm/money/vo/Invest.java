package com.cydm.money.vo;

import java.io.Serializable;
import java.util.Date;

public class Invest implements Serializable {

    private static final long serialVersionUID = 5486203404529631409L;

    private String productName;
    private double money;
    private Date time;
    private Integer status;
    public Invest(){}
    public Invest(String productName, double money, Date time, Integer status) {
        this.productName = productName;
        this.money = money;
        this.time = time;
        this.status = status;
    }

    /**
     * 重写方法防止哈希码相同
     * @return
     */
    @Override
    public int hashCode(){
        int hashCode = Integer.hashCode(productName.length());
        hashCode = hashCode * 31 + Float.hashCode(productName.length());
        hashCode = hashCode * 31 + (productName != null ? productName.hashCode():0);
        return hashCode;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
