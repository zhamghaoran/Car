package com.car.Database;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;

import java.util.List;

public interface GetCar {
    privateCar selectCarById(Integer id);

    truck selectTruckById(Integer id);

    List<privateCar> GetPrivateCarList();
    List<truck> GetTruckList();
}
