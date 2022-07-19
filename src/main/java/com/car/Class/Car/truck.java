package com.car.Class.Car;

public class truck extends Car{
    public Integer Load;

    public truck(String brand, Integer price, Integer id, Integer load) {
        super(brand, price, id);
        this.Load = load;
    }
    public Integer getLoad() {
        return Load;
    }
    public void setLoad(Integer load) {
        Load = load;
    }
}
