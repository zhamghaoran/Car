package com.car.Class.Car;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

public class Car {
    public String Brand;
    public Integer price;
    public Integer Id;
    public Integer state;
    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public Car(String brand, Integer price, Integer id, Integer state) {
        Brand = brand;
        this.price = price;
        Id = id;
        this.state = state;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getId() {
        return Id;
    }
    public Car(String brand, Integer price, Integer id) {
        Brand = brand;
        this.price = price;
        Id = id;
    }
}
