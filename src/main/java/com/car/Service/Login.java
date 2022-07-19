package com.car.Service;

import com.car.Database.Select;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/Car/login" )
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if (new Select().SelectUserLogin(username,password) == null) {
            resp.getWriter().println("登录失败 : 用户名错误或者密码错误");
        } else {
            resp.getWriter().println("登录成功");
        }
    }
}
