create table car.car_user
(
    Id       int auto_increment
        primary key,
    username varchar(20) NOT NULL ,
    password varchar(40) NOT NULL,
    money    int         null
);

