package com.car.Class;

public class Response {
    public int status_code;
    public String status_message;

    public Response(int status_code, String status_message) {
        this.status_code = status_code;
        this.status_message = status_message;
    }
    public Response(){}
}
