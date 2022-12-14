package com.attendance.controller;

import com.attendance.bean.Regulation;
import com.attendance.bean.User;
import com.attendance.bean.UserInformation;
import com.attendance.dao.RegulationDAO;
import com.attendance.dao.UserDao;
import com.attendance.dao.UserInformationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserControlServlet", value = "/UserControl")
public class UserControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        String name=request.getParameter("name");
        String department=request.getParameter("department");
        String degree=request.getParameter("degree");
        String sex=request.getParameter("sex");
        String work=request.getParameter("work");
        String user_type=request.getParameter("userType");
        String method=request.getParameter("method");
        if(method.equals("add"))
        {
            try{
            UserDao.createUser(new User(account,"123456",Integer.parseInt(user_type)));
        UserInformationDao.insertInfo(new UserInformation(account,name,department,degree,sex==null||sex.equals("true"),work));
        if(user_type.equals("0")){RegulationDAO.insertInfo(new Regulation(account,0,0));}}
        catch(RuntimeException e)
        {
            response.sendRedirect("/addUser.jsp?errorType=1");
            return;
        }

        }

        else if(method.equals("edit")){
            UserDao.updateUserType(new User(account,"123456",Integer.parseInt(user_type)));
            UserInformationDao.editInfo(new UserInformation(account,name,department,degree,sex==null||sex.equals("true"),work));
        }
        response.sendRedirect("/ManageUser.jsp");
    }
}
