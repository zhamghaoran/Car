package com.car.Class.Car;

import lombok.Data;

@Data
public class PrivateCar extends Car{
    public Integer people;
    public PrivateCar(String brand,Integer price,Integer id,Integer state,Integer people){
         super(brand,price,id,state);
         this.people=people;
    }

}
