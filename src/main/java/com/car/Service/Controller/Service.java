package com.car.Service.Controller;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;
import com.car.Class.User;
import com.car.Database.Select;
import com.car.Database.UpdateUser;
import com.google.gson.Gson;
import com.chenerzhu.common.util.SecureUtils;

import java.util.List;

public class Service {
    public String login(String username,String password) {
        if (new Select().SelectUserLogin(username,password) == null) {
            return "登录失败 : 用户名或者密码错误";
        } else {
            return "登录成功";
        }
    }
    public String register(String username,String password) {
        password = SecureUtils.getMD5(password);
        if (new Select().addUser(username,password) == null) {
            return "注册失败 : 用户名已存在";
        } else {
            return "注册成功";
        }
    }
    public String rent(String username,Integer id ,String type) {
        return "";
    }
    public String getprivatecarlist() {
        List<privateCar> privateCars = new Select().GetPrivateCarList();
        Gson gson = new Gson();
        return gson.toJson(privateCars);
    }
    public String gettrucklist() {
        List<truck> trucks = new Select().GetTruckList();
        Gson gson = new Gson();
        return gson.toJson(trucks);
    }
    public String recharge(String username ,Integer money) {
        User user = new Select().SelectUserByUsername(username);
        if (user == null)
            return "用户名错误";
        else {
            new UpdateUser().charge(user,money);
            return "充值成功";
        }
    }
}
