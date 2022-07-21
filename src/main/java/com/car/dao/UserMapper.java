package com.car.dao;

import com.car.Class.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //   登录时的验证

    @Select("select * from car_user where username = #{username} and password = #{password}")
    User SelectUserLogin(@Param("username") String username,@Param("password") String password);

    @Insert("insert into car_user(username,password) values(#{username},#{password})")
    Integer addUser(@Param("username") String username,@Param("password") String password);


    @Select("select * from car_user where username=#{username}")
    User SelectUserByUsername(String username);



}
