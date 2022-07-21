package com.car.Service.Controller;

import com.car.Class.Car.Car;
import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import com.car.dao.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Alltest {
    @Test
    public static  void main(String[] args){

        Select select = new Select();
//        System.out.println(select.addUser("test", "test"));
//        System.out.println(select.SelectUserLogin("test", "test"));
//        System.out.println(select.selectCarById(1).toString());
//        System.out.println(select.selectTruckById(1).toString());
//        System.out.println(select.getRentCar(user));
        Service service = new Service();
//        List<Truck> truckList=select.GetTruckList();
//        truckList.forEach((K) ->{
//            System.out.println(K.getBrand());
//        });
        List<PrivateCar> truckList = select.GetRentedPrivateCarList(1);
        truckList.forEach(k -> {System.out.println(k);});

    }

}
