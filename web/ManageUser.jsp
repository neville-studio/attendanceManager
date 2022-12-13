<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %><%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/13
  Time: 23:21
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
<%

  String find = request.getParameter("q");
  if(find==null)find="";
  UserInformation[] userInformations = UserInformationDao.getUsersInfo(find);

%>
<form id="search" style="vertical-align: middle"><input type="text" name="q" class="inputText" style="display: inline-block;width: 250px;height: 30px"><button type="submit" class="inputbutton" style="">查询</button> </form>
  <form action="/Manage">
      <div style="text-align: right; width: 80%;margin:0 auto">
      <button type="" class="inputbutton" name="method" value="add" style="text-align: right">添加用户</button></div>
    <table class="dataTable">
      <tr>
        <th>账户</th>
        <th>姓名</th>
        <th>部门</th>
        <th>职务</th>
        <th>操作</th>
      </tr>
<%
    for(int i = 0;i< userInformations.length;i++)
    {
%><tr>
      <td><%=userInformations[i].getAccount()%></td>
      <td><%=userInformations[i].getName()%></td>
      <td><%=userInformations[i].getDepartment()%></td>
      <td><%=userInformations[i].getWork()%></td>
      <td>
          <button name="edit" class="defaultButton" value="<%=userInformations[i].getAccount()%>">修改</button>
          <button name="reset" class="defaultButton" value="<%=userInformations[i].getAccount()%>">重置密码</button>
          <div class="warningButton del">删除用户</div>
          <button name="delete" class="warningButton confirm" value="<%=userInformations[i].getAccount()%>" style="display: none">确认删除</button>

      </td>
    </tr>

      <%}%>
    </table>
  </form>
<script>
    let array= document.getElementsByClassName("del");
    let array2= document.getElementsByClassName("confirm");
    for(let i = 0;i<array.length;i++)
    {
        array[i].addEventListener("click",()=>{
            for(let j=0;j<array.length;j++)
            {
                array2[i].style.display="none";
                array[i].style.display="inline-block";
            }
            array[i].style.display="none";
            array2[i].style.display="inline-block";
        })
    }
</script>
</body>
</html>
