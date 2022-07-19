package com.car.Class;

public class User {
    private String username;
    private String password;
    private Integer money;

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

    public User(String name, String password, Integer money) {
        username = name;
        this.password = password;
        this.money = money;
    }

}
