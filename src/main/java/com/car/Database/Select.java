package com.car.Database;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;
import com.car.Class.User;

import java.util.List;

public class Select implements GetUser,GetCar{
    /**
     * 查不到结果就返回null
     * */
    @Override
    public User SelectUserLogin(String username, String password) {
        return null;
    }
    @Override
    public Integer addUser(String username, String password) {
        return null;
    }
    /**
     * 如果发现用户已存在就返回空
     * 否则就返回User并且添加到数据库。
     * */
    @Override
    public User SelectUserByUsername(String username) {
        return null;
    }

    @Override
    public privateCar selectCarById(Integer id) {
        return null;
    }
    @Override
    public truck selectTruckById(Integer id) {
        return null;
    }

    @Override
    public List<privateCar> GetPrivateCarList() {
        return null;
    }

    @Override
    public List<truck> GetTruckList() {
        return null;
    }
}
