package com.car.Service.Controller;

import com.car.Class.Car.Car;
import com.car.Class.User;
import com.car.dao.Select;
import com.car.dao.UpdateUser;

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
        public String rent(String username,Integer id ,Integer type) {
        User user = new Select().SelectUserByUsername(username);
        if(user == null) return "用户不存在";
        Select select = new Select();
        Object getCar = select.getRentCar(user);
        if(getCar != null){
            return "已租车";
        }
        Car car;
        if (type == 1) {
            car = new Select().selectCarById(id);
            select.rentPrivateCar(user.getId(), car.getId());
        } else {
            car = new Select().selectTruckById(id);
        }
        if ( car == null) {
            return "车辆信息错误";
        }
//        new UpdateUser().UserRent(car,user);

        return "租车成功";
    }
}
