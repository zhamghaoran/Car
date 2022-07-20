package com.car.dao;

import com.car.Class.Car.Car;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RentMapper {

    @Select("select cartype from car_rent where userid = #{Id}")
    public Integer getRentCarType(User user);
    @Select("select carid from car_rent where userid=#{Id}")
    public Integer getRentCarId(User user);
    public Object getRentCar(User user);

    @Insert("insert into car_rent(userid,carid,cartype) values(#{userid},#{carid},2)")
    public int rentPrivateCar(@Param("userid") int userid, @Param("carid") int carid);
}