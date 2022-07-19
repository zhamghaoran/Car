package com.car.Database;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;
import com.car.Class.User;

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
}
