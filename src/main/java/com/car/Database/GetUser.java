package com.car.Database;

import com.car.Class.User;

public interface GetUser {
    //   登录时的验证
    User SelectUserLogin(String username, String password);

    Integer addUser(String username,String password);

}
