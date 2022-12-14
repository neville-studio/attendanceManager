package com.attendance.controller;

import com.attendance.bean.User;
import com.attendance.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordChangeServlet", value = "/PasswordChange")
public class PasswordChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account= request.getSession().getAttribute("account").toString();
        String password = request.getParameter("original");
        String newPassword = request.getParameter("newPassword");
        String retypePassword = request.getParameter("retypePassword");
        if(newPassword.equals(retypePassword))
        {
            if(UserDao.Login(new User(account,password,0))>=0)
            {
                if(UserDao.updatePassword(new User(account,newPassword,0))>0)
                response.sendRedirect("/userInfo.jsp");
                return;
            }else {response.sendRedirect("/changePassword.jsp?errorType=1");
                return;
            }
        }else {
            response.sendRedirect("/changePassword.jsp?errorType=2");
            return;
        }
    }
}
