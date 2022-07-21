create table car.car_rent
(
    id     int auto_increment
        primary key,

    userid int         not null,
    carid  int         not null,
    type  varchar(20)      not null
);

