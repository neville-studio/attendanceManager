<%@ page import="com.attendance.bean.UserInformation" %>
<%@ page import="com.attendance.dao.UserInformationDao" %>
<%@ page import="com.attendance.dao.RegulationDAO" %>
<%@ page import="com.attendance.bean.RegulationView" %>
<%@ page import="com.attendance.dao.RegulationViewDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
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
    RegulationView regulations[]  = RegulationViewDAO.findRegulations(find);

%>
<form id="search" style="vertical-align: middle"><input type="text" name="q" class="inputText" style="display: inline-block;width: 250px;height: 30px"><button type="submit" class="inputbutton" style="">查询</button> </form>
  <form action="/ManageAttendance">
      <div style="text-align: right; width: 80%;margin:0 auto">
        <input type="time" name="comeTime" value="08:00"><button type="" class="inputbutton" name="method" value="changeComeTime" style="text-align: right">修改上班时间</button>
        <input type="time" name="exitTime" value="17:00"><button type="" class="inputbutton" name="method" value="changeExitTime" style="text-align: right">修改下班时间</button>
      </div>
    <table class="dataTable">
      <tr>
        <th>账户</th>
        <th>姓名</th>
        <th>上班时间</th>
        <th>下班时间</th>
        <th>操作</th>
      </tr>
<%
    for(int i = 0;i< regulations.length;i++)
    {
%><tr>
      <td><%=regulations[i].getAccount()%></td>
      <td><%=regulations[i].getName()%></td>
      <td><%=new SimpleDateFormat("HH:mm").format(new Date(regulations[i].getComeTime()))%></td>
      <td><%=new SimpleDateFormat("HH:mm").format(new Date(regulations[i].getExitTime()))%></td>
      <td>
          <button name="edit" class="inputbutton" value="<%=regulations[i].getAccount()%>" >修改</button>

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
