package com.car.Service.Controller;

import com.car.Class.Car.Car;
import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.Response;
import com.car.Class.User;
import com.car.dao.Select;
import com.chenerzhu.common.util.SecureUtils;
import com.google.gson.Gson;

import java.util.List;

public class Service {
    Response response = new Response();

    public String login(String username, String password) {
        password = SecureUtils.getMD5(password);
        if (new Select().SelectUserLogin(username, password) == null) {
            response.status_code = 1;
            response.status_message = "用户名或者密码错误";
        } else {
            response.status_code = 0;
            response.status_message = "登录成功";
        }
        return new Gson().toJson(response);
    }

    public String register(String username, String password) {  // 注册
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

    public String rent(String username, Integer id, String type) { // 租车
        User user = new Select().SelectUserByUsername(username);
        Car car = null;
        int RentType = 0;
        if (type.equals("private")) {
            car = new Select().selectCarById(id);
            RentType = 2;
        } else {
            car = new Select().selectTruckById(id);
            RentType = 1;
        }
        //用户是不是已经租车，车是不是已经被用户租
        if (new Select().FindCarRentedOrNOt(car) || new Select().FindUserRentOrNot(user)) {
            return "车辆已经被别人租用或者用户已租用其他车辆";
        } else {
            //将用户和车辆加入租车表
            int isSuccess = 0;
            if (RentType == 1) {
                isSuccess = new Select().rentTruck(user.getId(), car.getId());
            } else {
                isSuccess = new Select().rentPrivateCar(user.getId(), car.getId());
            }
            if (isSuccess == 0) {
                response.status_code = 1;
                response.status_message = "出错了哟";
                return new Gson().toJson(response);
            } else {
                response.status_code = 0;
                response.status_message = "租车成功";
                return new Gson().toJson(response);
            }
        }
    }

    public String returncar(String username, Integer id) { //还车
        User user = new Select().SelectUserByUsername(username);
        int RentType = new Select().getRentCarType(user);

        if (RentType == 1) {
            int i = new Select().returnTruck(user.getId(), id);
        } else {
            int i = new Select().returnPrivateCar(user.getId(), id);
        }
        response.status_message = "还车成功";
        response.status_code = 0;
        return new Gson().toJson(response);
    }

    public String getprivatecarlist() {  // 获取小车列表
        List<PrivateCar> privateCars = new Select().GetPrivateCarList();
        Gson gson = new Gson();
        response.status_code = 0;
        response.status_message = null;
        return gson.toJson(response) + gson.toJson(privateCars);
    }

    public String gettrucklist() {   // 获取卡车列表
        List<Truck> trucks = new Select().GetTruckList();
        Gson gson = new Gson();
        return gson.toJson(trucks);
    }

    public String recharge(String username, Integer money) {  // 充值
        User user = new Select().SelectUserByUsername(username);
        if (user == null) {
            response.status_code = 1;
            response.status_message = "用户名错误";
            return new Gson().toJson(response);
        } else {
            response.status_code = 0;
            response.status_message = "充值成功";
        }
        new Select().ChargeMoney(user.getId(),money);
        return new Gson().toJson(response);
    }

}
