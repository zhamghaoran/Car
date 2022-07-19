package com.car.Database;

import com.car.Class.Car.privateCar;
import com.car.Class.Car.truck;

public interface GetCar {
    privateCar selectCarById(Integer id);

    truck selectTruckById(Integer id);
}
