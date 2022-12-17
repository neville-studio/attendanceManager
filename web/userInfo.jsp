<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %>
<%@ page import="com.attendance.bean.Regulation" %>
<%@ page import="com.attendance.dao.RegulationViewDAO" %>
<%@ page import="com.attendance.bean.RegulationView" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/13
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="StyleSheet/controls.css">
</head>
<%!
  UserInformation userInfo ;
%>
<%
  userInfo= UserInformationDao.getUserInfo(request.getSession().getAttribute("account").toString());
%>
<body>
<div class="section">
    <table class="table">
      <tr>
        <td width="75px">账号</td>
        <td><%=userInfo.getAccount()%></td>
      </tr>
      <tr>
        <td>姓名</td>
        <td><%=userInfo.getName()%></td>
      </tr>
      <tr>
        <td>部门</td>
        <td><%=userInfo.getDepartment()%></td>
      </tr>
      <tr>
        <td>学历</td>
        <td><%=userInfo.getDegree()%></td>
      </tr>
      <tr>
        <td>性别</td>
        <td><%=userInfo!=null&&userInfo.isSex()?"男":"女"%></td>
      </tr>
      <tr>
        <td>工作</td>
        <td><%=userInfo.getWork()%></td>
      </tr>
    </table>
</div>
<%
  if(request.getSession().getAttribute("user_type").toString().equals("0")){
  RegulationView regulation = RegulationViewDAO.findRegulationByaccount(userInfo.getAccount());
%>
<div style="height: 50px"></div>
<div class="section">
  <table class="table">
    <tr>
      <td width="150px">设定签到时间</td>
      <td><%=new SimpleDateFormat("HH:mm").format(new Date(regulation.getComeTime()))%></td>
    </tr>
    <tr>
      <td>设定签退时间</td>
      <td><%=new SimpleDateFormat("HH:mm").format(new Date(regulation.getExitTime()))%></td>
    </tr>
  </table>
</div>
<%}%>
</body>
</html>
