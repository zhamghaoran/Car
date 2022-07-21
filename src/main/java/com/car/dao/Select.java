package com.car.dao;

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
        return carMapper.selectTruckById(id);
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
    public Boolean FindUserRentOrNot(User user) {

        return true;
    }
    public int rentPrivateCar(int userid,  int carid){

        if(rentMapper.rentPrivateCar(userid,carid) > 0 && carMapper.updateTruckState(carid,1) > 0){
            return 1;
        }
        else return 0;
    }
}
