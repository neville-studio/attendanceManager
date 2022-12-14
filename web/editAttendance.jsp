<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %>
<%@ page import="com.attendance.bean.User" %>
<%@ page import="com.attendance.dao.UserDao" %>
<%@ page import="com.attendance.dao.RegulationViewDAO" %>
<%@ page import="com.attendance.bean.RegulationView" %>
<%@ page import="com.attendance.dao.RegulationDAO" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/13
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="StyleSheet/controls.css">
</head>
<%!
  RegulationView regulation;
%>
<%
  regulation = RegulationViewDAO.findRegulationByaccount(request.getParameter("user"));
%>
<body>

  <div class="section">
  <form method="post" action="/ManageAttendance">
    <table class="table">
      <tr>
        <td width="75px">账号</td>
        <td><input class="inputText" type="text" value="<%=regulation.getAccount()%>" name="account" readonly></td>
      </tr>
      <tr>
        <td>姓名</td>
        <td><input readonly class="inputText" type="text" value="<%=regulation.getName()%>" name="name"></td>
      </tr>
      <tr>
        <td>上班时间</td>
        <td><input class="inputText" type="time" value="<%=new SimpleDateFormat("HH:mm").format(regulation.getComeTime())%>" name="comeTime"></td>
      </tr>
      <tr>
        <td>下班时间</td>
        <td><input class="inputText" type="time" value="<%=new SimpleDateFormat("HH:mm").format(regulation.getExitTime())%>" name="exitTime"></td>
      </tr>
    </table>
    <button type="submit" class="inputbutton" name="method" value="edit">修改</button>
  </form>
</div>
</body>
</html>
