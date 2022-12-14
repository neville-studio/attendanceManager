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
                RecordDao.insertInfo(new Record(account, -1, -1, 0, date));
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm").parse(new SimpleDateFormat("HH:mm").format(new Date().getTime())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(nowRegultion.getComeTime()>timeofDay ) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未早打卡\"},\"enable\":true}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未晚打卡\",\"enable\":true}");
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
                    System.out.println(record.getExitTime());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(record.getComeTime()<0&&nowRegultion.getComeTime()>timeofDay){
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未早打卡\",\"enable\":true}");
                    response.setStatus(200);
                }else if(record.getExitTime()<0&& nowRegultion.getExitTime()<timeofDay){
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未晚打卡\",\"enable\":true}");
                    response.setStatus(200);
                }
                else if(record.getComeTime()>0&&nowRegultion.getComeTime()>timeofDay)
                {
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().print("{\"status\":\"已早打卡\",\"enable\":false}");
                    response.setStatus(200);
                }else if(record.getExitTime()>0&& nowRegultion.getExitTime()<timeofDay)
                {
                    //response.getWriter().flush();
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().print("{\"status\":\"已晚打卡\",\"enable\":false}");
                    //response.setStatus(200);

                    //
                }else
                {
                    response.setHeader("Content-Type","application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"不可打卡\",\"enable\":false}");
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
                RecordDao.insertInfo(new Record(account, -1, -1, 0, date));
                RegulationView nowRegultion = RegulationViewDAO.findRegulationByaccount(account);
                long timeofDay;
                try {
                    timeofDay = new SimpleDateFormat("HH:mm").parse(new SimpleDateFormat("HH:mm").format(new Date().getTime())).getTime();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                if(nowRegultion.getComeTime()>timeofDay ) {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未早打卡\"},\"enable\":true}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"未晚打卡\",\"enable\":true}");
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
                }if(nowRegultion.getComeTime()>timeofDay && record.getComeTime()<0 ) {
                    RecordDao.editInfo(new Record(account,timeofDay, record.getExitTime(), record.getStatus(), record.getDate()));
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"打卡成功\"},\"enable\":false}");
                    response.setStatus(200);
                }else if(nowRegultion.getExitTime()<timeofDay)
                {
                    RecordDao.editInfo(new Record(account, record.getComeTime(), timeofDay, record.getStatus(), record.getDate()));
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print("{\"status\":\"打卡成功\",\"enable\":false}");
                    response.setStatus(200);
                }

            }
        }
    }
}
