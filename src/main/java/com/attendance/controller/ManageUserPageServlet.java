package com.attendance.controller;

import com.attendance.bean.Regulation;
import com.attendance.bean.User;
import com.attendance.bean.UserInformation;
import com.attendance.dao.RegulationDAO;
import com.attendance.dao.UserDao;
import com.attendance.dao.UserInformationDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManageUserPageServlet", value = "/Manage")
public class ManageUserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        String edit = request.getParameter("edit");
        if(edit!=null)
        {
            //String user = edit.toString();
            response.sendRedirect("/editUser.jsp?user="+edit);
            return;
        }

        String reset = request.getParameter("reset");
        if(reset!=null)
        {
            //String user = edit.toString();
            UserDao.resetPassword(new User(reset,"",0));
            response.sendRedirect("/ManageUser.jsp");
            return;
        }
        String delete = request.getParameter("delete");
        if(delete!=null)
        {
            //String user = edit.toString();
            RegulationDAO.deleteInfo(new Regulation(delete,0,0));
            UserInformationDao.deleteInfo(new UserInformation(delete,null,null,null,false,null));
            UserDao.deleteUser(new User(delete,"",0));
            response.sendRedirect("/ManageUser.jsp");
            return;
        }
        if(method==null) {
            response.sendRedirect("/ManageUser.jsp");
            return;

        }
        if(method.equals("add"))
        {
            response.sendRedirect("/addUser.jsp");
            return;
        }
    }
}
