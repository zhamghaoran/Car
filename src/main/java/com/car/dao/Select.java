package com.car.dao;

import com.car.Class.Car.Car;
import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import com.car.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Select implements UserMapper, CarMapper,RentMapper {
    /**
     * 查不到结果就返回null
     * */
    private SqlSession session;
    private UserMapper userMapper;
    private Truck truck;
    private RentMapper rentMapper;
    private  CarMapper carMapper;

    public Select(){
        //新创建一个Session
        session = MybatisUtil.getSession(true);
        userMapper = session.getMapper(UserMapper.class);
        rentMapper = session.getMapper(RentMapper.class);
        carMapper = session.getMapper(CarMapper.class);
    }
    public User SelectUserLogin(String username, String password) {
        return userMapper.SelectUserLogin(username,password);
    }
    public Integer addUser(String username, String password) {

        if(userMapper.addUser(username,password) > 0) return 1;
        else return 0;
    }
    public User SelectUserByUsername(String username) {
        return userMapper.SelectUserByUsername(username);
    }

    public PrivateCar selectCarById(Integer id) {
        return carMapper.selectCarById(id);
    }
    public Truck selectTruckById(Integer id) {
        Truck truck =carMapper.selectTruckById(id);
        if(truck == null) return null;
        else return truck;
    }
    public Integer getRentCarType(User user) {
        Integer type = rentMapper.getRentCarType(user);
        if(type > 0) return  type;
        else return null;
    }
    public Integer getRentCarId(User user) {
        return rentMapper.getRentCarId(user);
    }
    public Object getRentCar(User user){
        System.out.println(user);

        Integer type = rentMapper.getRentCarType(user);
        if(type == null){
            return null;
        }
        else if(type.intValue() == 1){
            PrivateCar privateCar =carMapper.selectCarById(rentMapper.getRentCarId(user));
            return privateCar;
        }else if(type.intValue() == 2) {
            Truck truck = carMapper.selectTruckById(rentMapper.getRentCarId(user));
            return truck;
        }
        return null;
    }
    public int updateTruckState(Integer carid,Integer value){
        if(carMapper.updateTruckState(carid,value) > 0)return 1;
        else return 0;
    }
    public int updatePrivateState(Integer carid,Integer value){
        if(carMapper.updatePrivateState(carid,value) > 0)return 1;
        else return 0;
    }
    @Override
    public List<PrivateCar> GetRentedPrivateCarList(Integer userid) {
        List<PrivateCar>  privateCarList= rentMapper.GetRentedPrivateCarList(userid);
        if(privateCarList == null) return null;
        return privateCarList;
    }
    @Override
    public List<Truck> GetRentedTruckList(Integer  userid) {
        List<Truck> truckList = rentMapper.GetRentedTruckList(userid);
        if(truckList == null) return null;
        else return truckList;
    }

    @Override
    public int returnPrivateCar(Integer userid, Integer carid) {
        int i = rentMapper.returnPrivateCar(userid, carid);
        return i;
    }

    @Override
    public int returnTruck(Integer userid, Integer carid) {
        int i = rentMapper.returnTruck(userid, carid);
        return i;
    }

    public Boolean FindUserRentOrNot(User user) {
        if(new Select().getRentCar(user) == null) return false;
        else return true;
    }
    public boolean FindCarRentedOrNOt(Car car){
        return (car.state == 1);//0表示没租，1表示已经租出去
    }
    public List<PrivateCar> GetPrivateCarList(){
        List<PrivateCar> privateCarList = carMapper.GetPrivateCarList();
        if(privateCarList == null) return null;
        else return privateCarList;
    }

    public PrivateCar selectPrivateById(Integer id){
        PrivateCar car = selectPrivateById(id);
        if(car == null) return null;
        return car;
    }

    public List<Truck> GetTruckList() {
        List<Truck> truckList = carMapper.GetTruckList();
        if(truckList == null) return null;
        else return truckList;
    }
    public int rentPrivateCar(int userid,  int carid){
        PrivateCar toRentCar = carMapper.selectPrivateById(carid);
        if((toRentCar.getState() != 0 && toRentCar.getState() != null) || toRentCar == null) return 0;
        if(rentMapper.rentPrivateCar(userid,carid) > 0 && carMapper.updatePrivateState(carid,1) > 0){
            return 1;
        }
        else return 0;
    }
    public int rentTruck(int userid,  int carid){
        Truck truck1 = carMapper.selectTruckById(carid);
        if((truck1.getState() != 0 && truck1.getState() != null) || truck1 == null) return 0;
        if(rentMapper.rentTruck(userid,carid) > 0  && carMapper.updateTruckState(carid,1) > 0){
            return 1;
        }
        else return 0;
    }
}