package com.nidong.test.entity;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nidong.test")
public class Account {

    private String aname;//账户名称
    private String num;//账户编号
    private double money;//金额

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aname='" + aname + '\'' +
                ", num='" + num + '\'' +
                ", money=" + money +
                '}';
    }
}
