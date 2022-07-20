package com.car.Class;

public class User {
    private String username;
    private String password;
    private Integer money;

    public User(String username, String password, Integer money) {
        this.username = username;
        this.password = password;
        this.money = money;
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
