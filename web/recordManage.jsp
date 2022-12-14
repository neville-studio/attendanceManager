<%@ page import="com.attendance.dao.RecordDao" %>
<%@ page import="com.attendance.bean.Record" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.attendance.bean.RecordView" %>
<%@ page import="com.attendance.dao.RecordViewDao" %><%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/14
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="StyleSheet/controls.css">
  <style>
    #search
    {
      display: inline-block;
    }
  </style>
</head>
<body>
<table class="dataTable">
<%
  String account = request.getSession().getAttribute("account").toString();

  if(request.getSession().getAttribute("user_type").toString().equals("0")){
    Record[] records = RecordDao.findRecords(account);
%>


    <tr>
      <th>账户</th>
      <th>日期</th>
      <th>签到时间</th>
      <th>签退时间</th>
    </tr>
    <%
      for(int i = 0;i< records.length;i++)
      {
    %><tr>
    <td><%=records[i].getAccount()%></td>
    <td><%=new SimpleDateFormat("YYYY-MM-dd").format(new Date(records[i].getDate()))%></td>
    <td><%=records[i].getComeTime()>=-28800000L?""+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(records[i].getComeTime())):""%></td>
    <td><%=records[i].getExitTime()>=-28800000L?""+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(records[i].getExitTime())):""%></td>

  </tr>

    <%}}else {
      String q = request.getParameter("q");
      if(q==null)q="";
      RecordView[] records = RecordViewDao.findAllRecords(q);
    %>
  <form id="search" style="vertical-align: middle"><input type="text" name="q" class="inputText" style="display: inline-block;width: 250px;height: 30px"><button type="submit" class="inputbutton" style="">按姓名查询</button> </form>
  <tr>
    <th>账户</th>
    <th>姓名</th>
    <th>签到日期</th>
    <th>签到时间</th>
    <th>签退时间</th>
  </tr>
  <%
    for(int i = 0;i< records.length;i++)
    {
  %><tr>
  <td><%=records[i].getAccount()%></td>
  <td><%=records[i].getName()%></td>
  <td><%=new SimpleDateFormat("YYYY-MM-dd").format(new Date(records[i].getDate()))%></td>
  <td><%=records[i].getCometime()>=-28800000L?""+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(records[i].getCometime())):""%></td>
  <td><%=records[i].getExitTime()>=-28800000L?""+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(records[i].getExitTime())):""%></td>
</tr>
  <%
    }}
  %>
  </table>

</body>
</html>
