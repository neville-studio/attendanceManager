package com.attendance.controller;

import com.attendance.bean.UserInformation;
import com.attendance.dao.UserInformationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet", value = "/EditUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserInformation userInformation =  new UserInformation();
        userInformation.setAccount(request.getParameter("account"));
        userInformation.setName(request.getParameter("name"));
        userInformation.setWork(request.getParameter("work"));
        userInformation.setSex(request.getParameter("sex")!=null&&request.getParameter("sex").equals("true"));
        userInformation.setDepartment(request.getParameter("department"));
        userInformation.setDegree(request.getParameter("degree"));
        UserInformationDao.editInfo(userInformation);
        response.sendRedirect("/userInfo.jsp");
    }
}
