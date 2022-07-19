create table car.car_user
(
    Id       int auto_increment
        primary key,
    username varchar(20) null,
    password varchar(40) null,
    money    int         null,
    rent     int         null
);

