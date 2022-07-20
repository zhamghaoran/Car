package com.car.Service.Controller;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;
import com.car.Class.Response;
import com.car.Class.User;
import com.car.Database.Select;
import com.car.Database.UpdateUser;
import com.google.gson.Gson;
import com.chenerzhu.common.util.SecureUtils;

import java.util.List;
public class Service {
    Response response = new Response();
    public String login(String username, String password) {
        if (new Select().SelectUserLogin(username, password) == null) {
            response.status_code = 1;
            response.status_message = "用户名或者密码错误";
        } else {
            response.status_code = 0;
            response.status_message = "登录成功";
        }
        return new Gson().toJson(response);
    }
    public String register(String username, String password) {
        password = SecureUtils.getMD5(password);
        if (new Select().addUser(username, password) == null) {
            response.status_code = 1;
            response.status_message = "用户名已存在";
        } else {
            response.status_code = 0;
            response.status_message = "注册成功";
        }
        return new Gson().toJson(response);
    }

    public String rent(String username, Integer id, String type) {
        return "";
    }

    public String getprivatecarlist() {
        List<privateCar> privateCars = new Select().GetPrivateCarList();
        Gson gson = new Gson();
        response.status_code = 0;
        response.status_message = null;
        return gson.toJson(response) + gson.toJson(privateCars);
    }

    public String gettrucklist() {
        List<truck> trucks = new Select().GetTruckList();
        Gson gson = new Gson();
        return gson.toJson(trucks);
    }

    public String recharge(String username, Integer money) {
        User user = new Select().SelectUserByUsername(username);
        if (user == null) {
            response.status_code = 1;
            response.status_message = "用户名错误";
        } else {
            new UpdateUser().charge(user, money);
            response.status_code = 0;
            response.status_message = "充值成功";
        }
        return new Gson().toJson(response);
    }
}
