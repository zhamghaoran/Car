package com.car.Class.Car;

public class Car {
    public String Brand;
    public Integer price;
    public Integer Id;

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
