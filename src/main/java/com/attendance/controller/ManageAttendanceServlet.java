package com.attendance.controller;

import com.attendance.bean.Regulation;
import com.attendance.dao.RegulationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ManageAttendanceServlet", value = "/ManageAttendance")
public class ManageAttendanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String edit = request.getParameter("edit");
        if(edit!=null)
        {
            //String user = edit.toString();
            response.sendRedirect("/editAttendance.jsp?user="+edit);
            return;
        }
        if(method==null) {
            response.sendRedirect("/ManageAttendance.jsp");
            return;

        }else if(method.equals("changeComeTime"))
        {
            String time = request.getParameter("comeTime");
            long setValue = 0;
            try {
                setValue = new SimpleDateFormat("HH:mm").parse(time).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            RegulationDAO.editInfos("comeTime",setValue);
            response.sendRedirect("/ManageAttendance.jsp");
            return;
        }else if(method.equals("changeExitTime"))
        {
            String time = request.getParameter("exitTime");
            long setValue = 0;
            try {
                setValue = new SimpleDateFormat("HH:mm").parse(time).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            RegulationDAO.editInfos("ExitTime",setValue);
            response.sendRedirect("/ManageAttendance.jsp");
            return;
        }
        else if(method.equals("edit"))
        {
            String time = request.getParameter("exitTime");
            String account = request.getParameter("account");
            String cometime = request.getParameter("comeTime");
            long setValue = 0;
            long setComeValue = 0;
            try {
                setValue = new SimpleDateFormat("HH:mm").parse(time).getTime();
                setComeValue = new SimpleDateFormat("HH:mm").parse(cometime).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            RegulationDAO.editInfo(new Regulation(account,setComeValue,setValue));
            response.sendRedirect("/ManageAttendance.jsp");
            return;
        }
    }
}
