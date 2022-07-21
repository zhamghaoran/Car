package com.car.dao;

import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RentMapper {

    @Select("select cartype from car_rent where userid = #{Id}")
    public Integer getRentCarType(User user);
    @Select("select carid from car_rent where userid=#{Id}")
    public Integer getRentCarId(User user);
    public Object getRentCar(User user);

    @Insert("insert into car_rent(userid,carid,cartype) values(#{userid},#{carid},2)")
    public int rentPrivateCar(@Param("userid") int userid, @Param("carid") int carid);

    @Insert("insert into car_rent(userid,carid,cartype) values(#{userid},#{carid},1)")
    public int rentTruck(@Param("userid") int userid, @Param("carid") int carid);
    @Select("select * from car_rent inner join car_privatecar on car_rent.carid = car_privatecar.id where car_rent.userid = #{userid} and car_rent. cartype = 1")
    List<PrivateCar> GetRentedPrivateCarList(Integer userid);
    @Select("select * from car_rent inner join car_truck on car_rent.carid = car_truck.id where car_rent.userid = #{userid} and car_rent.cartype = 2")
    List<Truck> GetRentedTruckList(Integer userid);

}