package com.car.dao;

import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {
    @Select("select * from car_privatecar where id = #{id}")
    PrivateCar selectCarById(Integer id);

//    @ConstructorArgs({
//            @Arg(column = "brand",javaType = String.class),
//            @Arg(column = "price" ,javaType = Integer.class),
//            @Arg(column = "id", javaType = Integer.class),
//            @Arg(column = "state", javaType = Integer.class),
//            @Arg(column = "load", javaType = Integer.class)
//    })
    @Select("select * from car_truck where id = #{id}")
    Truck selectTruckById(Integer id);
    @Select("select * from car_privatecar where id = #{id}")
    PrivateCar selectPrivateById(Integer id);
    @Update("update car_truck set state=#{value} where id=#{id}")
    int updateTruckState(@Param("id") Integer id,@Param("value") Integer value);

    @Select("select * from car_privatecar")
    public List<PrivateCar> GetPrivateCarList();
    @Update("update car_privatecar set state=#{value} where id=#{id}")
    public int updatePrivateState(@Param("id") Integer carid,@Param("value") Integer value);
    @Select("select * from car_truck")
    public List<Truck> GetTruckList();


}
