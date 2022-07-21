package com.car.Class.Car;

import lombok.Data;

@Data

public class Truck extends Car{
    public Integer load;
    public Truck(){};
    public Truck(String brand, Integer price, Integer id, Integer state,Integer load) {
        super(brand, price, id, state);
        this.load = load;
    }



//    public Integer getLoad() {
//        return load;
//    }
//    public void setLoad(Integer load) {
//        this.load = load;
//    }
}
