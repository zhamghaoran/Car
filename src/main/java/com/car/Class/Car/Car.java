package com.car.Class.Car;


import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;

@Data //Lombok
@Accessors(chain = true) //开启链式调用
public class Car {
    public String brand;
    public Integer price;
    public Integer id;
    public Integer state;


//    public Car(String brand, Integer price, Integer id, Integer state) {
//        this.brand = brand;
//        this.price = price;
//        this.id = id;
//        this.state = state;
//    }
}
