package com.car.Class;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private int id;
    private String username;
    private String password;
    private Integer money;

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
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

    public User(int id, String username, String password, Integer money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }
}
