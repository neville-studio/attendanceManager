<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %><%--
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
    <style>
      .table
      {
        margin: 0 10%;
        width:80%;
      }
      .table tr
      {
        height:40px;
      }
      .section
      {
        display: inline-block;
        width:80%;
        margin: 0 auto;
        text-align: center;
        border:1px solid #ddd;
        box-shadow: 5px 5px 50px #aaa;
        border-radius: 4px;
        background-image: linear-gradient(60deg,rgba(218, 169, 215, 0.3),rgba(128, 174, 235, 0.426));
        backdrop-filter: opacity(75%);
      }
      body
      {
        text-align: center;
      }
    </style>
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
        <td><%=userInfo==null&&userInfo.isSex()?"男":"女"%></td>
      </tr>
      <tr>
        <td>工作</td>
        <td><%=userInfo.getWork()%></td>
      </tr>
    </table>
</div>
</body>
</html>
