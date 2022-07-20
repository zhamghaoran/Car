package com.car.dao;

import com.car.Class.Car.Car;
import com.car.Class.Car.PrivateCar;
import com.car.Class.Car.Truck;
import com.car.Class.User;
import com.car.util.MybatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

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

        User user = userMapper.SelectUserLogin(username,password);
        if(user == null) return null;
        else return user;
    }

    public Integer addUser(String username, String password) {


        if(userMapper.addUser(username,password) > 0) return 1;
        else return 0;

    }

    public User SelectUserByUsername(String username) {
        User user= userMapper.SelectUserByUsername(username);
        if(user == null) return null;
        else return user;
    }


    public PrivateCar selectCarById(Integer id) {
        PrivateCar car = carMapper.selectCarById(id);
        if(car == null) return null;
        else return car;
    }

    public Truck selectTruckById(Integer id) {
        Truck car = carMapper.selectTruckById(id);
        if(car == null)return null;
        else return car;
    }


    public Integer getRentCarType(User user) {
        Integer type = rentMapper.getRentCarType(user);
        if(type > 0) return  type;
        else return null;
    }


    public Integer getRentCarId(User user) {
        Integer id = rentMapper.getRentCarId(user);
        return id;
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
    public int rentPrivateCar(int userid,  int carid){

        if(rentMapper.rentPrivateCar(userid,carid) > 0 && carMapper.updateTruckState(carid,1) > 0){

            return 1;
        }
        else return 0;
    }
}
