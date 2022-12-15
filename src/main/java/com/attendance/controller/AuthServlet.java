package com.attendance.controller;

import com.attendance.bean.User;
import com.attendance.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/Auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().print("{\"status\":\"不支持此请求方式！\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");

        String password = request.getParameter("password");
        int status =UserDao.Login(new User(account,password,0));
        if(status<0)
        {
            //response.sendError(200);
            //response.setContentType("text/plain");
            //response.getWriter().println("{\"status\":\"登录失败，用户名或密码错误\"}");
            response.sendRedirect("/index.jsp?errortype=2");
            return;
        }else {
            request.getSession().setAttribute("account",account);
            request.getSession().setAttribute("user_type",status);

//            response.sendError(200);
//            response.setContentType("text/plain");
//            response.getWriter().println("{\"status\":\"登录成功\"}");
            response.sendRedirect("/homepage.jsp");
            return;
        }

    }
}
