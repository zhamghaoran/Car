package com.car.Service.Controller;

import com.car.Class.Car.Car;
import com.car.Class.User;
import com.car.dao.Select;

public class Alltest {

    public static  void main(String[] args){
        User user = new User().setUsername("test").setPassword("test").setId(1).setMoney(123);
        Select select = new Select();
//        System.out.println(select.addUser("test", "test"));
//        System.out.println(select.SelectUserLogin("test", "test"));
//        System.out.println(select.selectCarById(1).toString());
//        System.out.println(select.selectTruckById(1).toString());
//        System.out.println(select.getRentCar(user));
        Service service = new Service();
        service.rent("test",1,1);

    }

}
