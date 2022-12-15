package com.attendance.controller;

import com.attendance.bean.Record;
import com.attendance.bean.Regulation;
import com.attendance.bean.RegulationView;
import com.attendance.dao.RecordDao;
import com.attendance.dao.RegulationDAO;
import com.attendance.dao.RegulationViewDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SignServlet", value = "/Sign")
public class SignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String account = request.getSession().getAttribute("account").toString();
        if(method==null)
        {
            long date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime())).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Record record = RecordDao.getRecord(account,date);
            if(record==null) {
                RecordDao.insertInfo(new Record(account, -28800001L, -28800001L, 0, date));
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm").parse(new SimpleDateFormat("HH:mm").format(new Date().getTime())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(nowRegultion.getComeTime()>timeofDay ) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签到\",\"enable\":true}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签退\",\"enable\":true}");
                    response.setStatus(200);
                }else{
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"不可签到\",\"enable\":false}");
                    response.setStatus(200);
                }
            }else
            {
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm:ss.SSS").parse(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date().getTime())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(record.getComeTime()<-28800000L&&nowRegultion.getComeTime()>timeofDay){
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签到\",\"enable\":true}");
                    response.setStatus(200);
                }else if(record.getExitTime()<-28800000L&& nowRegultion.getExitTime()<timeofDay){
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签退\",\"enable\":true}");
                    response.setStatus(200);
                }
                else if(record.getComeTime()>=-28800000L&&nowRegultion.getComeTime()>timeofDay)
                {
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().print("{\"status\":\"已签到\",\"enable\":false}");
                    response.setStatus(200);
                }else if(record.getExitTime()>-28800000L&& nowRegultion.getExitTime()<timeofDay)
                {
                    //response.getWriter().flush();
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().print("{\"status\":\"已签退\",\"enable\":false}");
                    //response.setStatus(200);

                    //
                }else
                {
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"不可签到\",\"enable\":false}");
                    response.setStatus(200);
                }
            }
        }else {
            long date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime())).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Record record = RecordDao.getRecord(account,date);
            if(record==null) {
                RecordDao.insertInfo(new Record(account, -28800001, -28800001, 0, date));
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm").parse(new SimpleDateFormat("HH:mm").format(new Date().getTime())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(nowRegultion.getComeTime()>timeofDay ) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签到\",\"enable\":true}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未签退\",\"enable\":true}");
                    response.setStatus(200);
                }else{
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"不可签到\",\"enable\":false}");
                    response.setStatus(200);
                }
            }else
            {
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm:ss.SSS").parse(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }if(nowRegultion.getComeTime()>timeofDay && record.getComeTime()<-28800000L ) {
                    RecordDao.editInfo(new Record(account,timeofDay, record.getExitTime(), record.getStatus(), record.getDate()));
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"签到成功\",\"enable\":false}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    RecordDao.editInfo(new Record(account, record.getComeTime(), timeofDay, record.getStatus(), record.getDate()));
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"签退成功\",\"enable\":false}");
                    response.setStatus(200);
                }

            }
        }
    }
}
