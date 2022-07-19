package com.car.Service.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String servletPath = req.getServletPath();
        String substring = servletPath.substring(5);
        Method[] declaredMethods = Service.class.getDeclaredMethods();
        for (Method m : declaredMethods) {
            if (m.getName().equals(substring)) {
                Parameter[] parameters = m.getParameters();
                Object[] parametersValues =  new Object[parameters.length];
                for (int i = 0;i < parameters.length;i ++) {
                    parametersValues[i] = req.getParameter(parameters[i].getName());
                }
                try {
                    Object invoke = m.invoke(new Service(), parametersValues);
                    resp.getWriter().println(invoke);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
