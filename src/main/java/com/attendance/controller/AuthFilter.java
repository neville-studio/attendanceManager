package com.attendance.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns = "*")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if((httpServletRequest.getSession(false)==null||httpServletRequest.getSession(false).getAttribute("user_type")==null)&&!httpServletRequest.getRequestURI().equals("/index.jsp")&&!httpServletRequest.getRequestURI().equals("/Auth"))
        {

            httpServletResponse.sendRedirect("/index.jsp");
            return;
        }else if(!(httpServletRequest.getSession(false)==null||httpServletRequest.getSession(false).getAttribute("user_type")==null)&&(httpServletRequest.getRequestURI().equals("/index.jsp")||httpServletRequest.getRequestURI().equals("/")))
        {

            httpServletResponse.sendRedirect("/homepage.jsp");
            return;
        }
        int user_type;
        try{
         user_type = Integer.parseInt(httpServletRequest.getSession().getAttribute("user_type").toString());}catch (Exception e){
            user_type = 0;
        }
        switch(httpServletRequest.getRequestURI())
        {
            case "/ManageAttendance.jsp":
            case "/ManageAttendance":
            case "/editAttendance.jsp":
                if(user_type==0){
                    httpServletResponse.sendRedirect("/homepage.jsp");
                    return;
                }
                break;
            case "/ManageUser.jsp":
            case "/addUser.jsp":
            case "/editUser.jsp":
            case "/Manage":
            case "/UserControl":
                if(user_type!=2){
                    httpServletResponse.sendRedirect("/homepage.jsp");
                    return;
                }
                break;
            case "/Sign":
                if(user_type!=0){
                    httpServletResponse.sendRedirect("/homepage.jsp");
                    return;
                }
                break;
        }
        chain.doFilter(request, response);
    }
}
