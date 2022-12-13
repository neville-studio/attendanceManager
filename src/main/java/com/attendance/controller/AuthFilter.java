package com.attendance.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
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
        if(httpServletRequest.getSession(false).getAttribute("user_type")==null&&!httpServletRequest.getLocalAddr().equals("index.jsp")&&!httpServletRequest.getLocalAddr().equals("/Auth"))
        {
            httpServletResponse.sendRedirect("/index.jsp");
        }
        chain.doFilter(request, response);
    }
}
