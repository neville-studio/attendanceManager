package com.attendance.controller;

import com.attendance.bean.User;
import com.attendance.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/Auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        response.getOutputStream().print("{\"status\":\"不支持此请求方式！\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = (String)request.getSession().getAttribute("account");
        String password = (String)request.getSession().getAttribute("password");
        int status =UserDao.Login(new User(account,password,0));
        if(status<=0)
        {
            response.sendError(200);
            response.setContentType("text/plain");

            response.getOutputStream().println("{\"status\":\"登录失败，用户名或密码错误\"}");
        }else {
            request.getSession().setAttribute("account",account);
            request.getSession().setAttribute("user_type",status);
            response.sendRedirect("");
        }

    }
}
