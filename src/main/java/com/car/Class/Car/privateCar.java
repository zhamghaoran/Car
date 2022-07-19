package com.car.Class.Car;

public class privateCar extends Car{
    public Integer People;
    public privateCar(String brand, Integer price, Integer id, Integer people) {
        super(brand, price, id);
        People = people;
    }
    public Integer getPeople() {
        return People;
    }
    public void setPeople(Integer people) {
        People = people;
    }
}
