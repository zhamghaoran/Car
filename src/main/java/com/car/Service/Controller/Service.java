package com.car.Service.Controller;

import com.car.Class.Car.Car;
import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;
import com.car.Class.User;
import com.car.Database.Select;
import com.car.Database.UpdateUser;

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
    public String rent(String username,Integer id ,String type) {
        User user = new Select().SelectUserByUsername(username);
        if (user.getRent() == 1) {
            return "已租车";
        }
        Car car;
        if (type.equals("privateCar")) {
            car = new Select().selectCarById(id);
        } else {
            car = new Select().selectTruckById(id);
        }
        if ( car == null) {
            return "车辆信息错误";
        }
        new UpdateUser().UserRent(car,user);
        return "租车成功";
    }
}
