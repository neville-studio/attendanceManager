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
  <form method="post" action="/EditUser">
  <table class="table">
    <tr>
      <td width="75px">账号</td>
      <td><input class="inputText" type="text" value="<%=userInfo.getAccount()%>" name="account" readonly></td>
    </tr>
    <tr>
      <td>姓名</td>
      <td><input class="inputText" type="text" value="<%=userInfo.getName()%>" name="name"></td>
    </tr>
    <tr>
      <td>部门</td>
      <td><input class="inputText" type="text" value="<%=userInfo.getDepartment()%>" name="department"></td>
    </tr>
    <tr>
      <td>学历</td>
      <td>
        <select class="inputText" name="degree" id="">
          <option value="null" <%=userInfo.getDegree().equals("null")?"selected":""%>>请选择</option>
        <option value="小学" <%=userInfo.getDegree().equals("小学")?"selected":""%>>小学</option>
        <option value="初中" <%=userInfo.getDegree().equals("初中")?"selected":""%>>初中</option>
        <option value="高中" <%=userInfo.getDegree().equals("高中")?"selected":""%>>高中</option>
        <option value="中专" <%=userInfo.getDegree().equals("中专")?"selected":""%>>中专</option>
        <option value="大专" <%=userInfo.getDegree().equals("大专")?"selected":""%>>大专</option>
        <option value="本科" <%=userInfo.getDegree().equals("本科")?"selected":""%>>本科</option>
        <option value="硕士" <%=userInfo.getDegree().equals("硕士")?"selected":""%>>硕士</option>
        <option value="博士" <%=userInfo.getDegree().equals("博士")?"selected":""%>>博士</option>
      </select></td>
    </tr>
    <tr>
      <td>性别</td>
      <td><input  type="radio" name="sex" value="true" <%=userInfo!=null&&userInfo.isSex()?"checked":""%> id="male"><label for="male">男</label>
        <input type="radio" name="sex" value="false" <%=userInfo!=null&&!userInfo.isSex()?"checked":""%> id="female"><label for="female">女</label>
      </td>
    </tr>
    <tr>
      <td>工作</td>
      <td><input class="inputText" type="text" value="<%=userInfo.getWork()%>" name="work"></td>
    </tr>
  </table>
    <button type="submit" class="inputbutton">修改</button>
  </form>
</div>
</body>
</html>
