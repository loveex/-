package com.example.shuiguodian.data;

import cn.bmob.v3.BmobUser;

public class USER extends BmobUser {

    private String gonghao;
    private String name;
    private String money;
    private String shop;

    public String getGonghao() {
        return gonghao;
    }

    public  String getName(){
        return name;
    }

    public String getMoney(){
        return money;
    }
    public String getShop(){
        return shop;
    }
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    public void setShop(String shop){
        this.shop = shop;
    }
}
