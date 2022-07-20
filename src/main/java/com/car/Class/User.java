package com.car.Class;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private int Id;
    private String username;
    private String password;
    private Integer money;



    public String rentCat(String id,String type) {

        return null;
    }

}
