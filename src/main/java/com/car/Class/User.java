package com.car.Class;

import com.sun.tools.sjavac.comp.PubapiVisitor;

public class User {
    private String username;
    private String password;
    private Integer money;
    public Integer rent;
    public void setRent(Integer rent) {
        this.rent = rent;
    }
    public Integer getRent() {
        return rent;
    }
    public User(String username, String password, Integer money, Integer rent) {
        this.username = username;
        this.password = password;
        this.money = money;
        this.rent = rent;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getMoney() {
        return money;
    }
    public String rentCat(String id,String type) {

        return null;
    }
}
