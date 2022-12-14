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

<body>
<div class="section">
  <form method="post" action="/UserControl">
  <table class="table">
    <tr>
      <td width="75px">账号</td>
      <td><input class="inputText" type="text" value="" name="account"></td>
    </tr>
    <tr>
      <td>姓名</td>
      <td><input class="inputText" type="text" value="" name="name"></td>
    </tr>
    <tr>
      <td>部门</td>
      <td><input class="inputText" type="text" value="" name="department"></td>
    </tr>
    <tr>
      <td>学历</td>
      <td>
        <select class="inputText" name="degree" id="">
        <option value="null">请选择</option>
        <option value="小学">小学</option>
        <option value="初中">初中</option>
        <option value="高中">高中</option>
        <option value="中专">中专</option>
        <option value="大专">大专</option>
        <option value="本科">本科</option>
        <option value="硕士">硕士</option>
        <option value="博士">博士</option>
      </select></td>
    </tr>
    <tr>
      <td>性别</td>
      <td><input  type="radio" name="sex" value="true"  id="male"><label for="male">男</label>
        <input type="radio" name="sex" value="false" id="female"><label for="female">女</label>
      </td>
    </tr>
    <tr>
      <td>工作</td>
      <td><input class="inputText" type="text"  name="work"></td>
    </tr>
    <tr>
      <td>权限</td>
      <td>
        <select class="inputText" name="userType">
          <option value="0">用户</option>
          <option value="1">管理员</option>
        </select></td>
    </tr>
  </table>
    <div>
      &nbsp;
      <%
        if(request.getParameter("errorType")!=null)
          out.print("该账号已注册。");
      %>
    </div>
    <button type="submit" class="inputbutton" name="method" value="add">添加</button>

  </form>
</div>
</body>
</html>
