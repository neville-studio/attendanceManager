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
        }else if(!(httpServletRequest.getSession(false)==null||httpServletRequest.getSession(false).getAttribute("user_type")==null)&&httpServletRequest.getRequestURI().equals("/index.jsp"))
        {

            httpServletResponse.sendRedirect("/homepage.jsp");
            return;
        }
        chain.doFilter(request, response);
    }
}
