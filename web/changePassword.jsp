<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %><%--
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
  <style>
    .section{
      width:400px;
    }
  </style>
</head>
<%!
  UserInformation userInfo ;
%>
<%
  userInfo= UserInformationDao.getUserInfo(request.getSession().getAttribute("account").toString());
  if(userInfo.getDegree()==null)userInfo.setDegree("null");
%>
<body>
<div class="section">
  <form method="post" action="/PasswordChange">
  <table class="table">
    <tr>
      <td width="75px">原密码</td>
      <td><input class="inputText" type="password" name="original"></td>
    </tr>
    <tr>
      <td>新密码</td>
      <td><input class="inputText" type="password"  name="newPassword"></td>
    </tr>
    <tr>
      <td>再输一次</td>
      <td><input class="inputText" type="password" name="retypePassword"></td>
    </tr>
  </table>
    <div>&nbsp<%
        if(request.getParameter("errorType")!=null&&request.getParameter("errorType").equals("2"))
          out.print("两次密码要输入一致");
        else if(request.getParameter("errorType")!=null&&request.getParameter("errorType").equals("1"))
          out.print("原密码错误");
    %></div>
    <button type="submit" class="inputbutton">修改</button>
  </form>
</div>
</body>
</html>
