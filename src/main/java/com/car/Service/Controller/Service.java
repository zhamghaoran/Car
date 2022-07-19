package com.car.Service.Controller;

import com.car.Database.Select;

import java.security.PublicKey;

public class Service {
    public String login(String username,String password) {
        if (new Select().SelectUserLogin(username,password) == null) {
            return "登录失败 : 用户名或者密码错误";
        } else {
            return "登录成功";
        }
    }
    public String register(String username,String password) {
        if (new Select().addUser(username,password) == null) {
            return "注册失败 : 用户名已存在";
        } else {
            return "注册成功";
        }
    }
}
