<%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/13
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="StyleSheet/stylesheet.css">
</head>
<body>
    <div class="title">
<%--        <div class="menu">--%>
            <div class="left">
            <div class="item" onclick="document.getElementById('info').setAttribute('src','userInfo.jsp')">首页</div>
            <div class="item">查询记录</div>
            <div class="item">管理人员</div>
            <div class="item">管理签到时间</div>
            </div><div class="right">
            <div class="item"><%=request.getSession().getAttribute("account").toString()%></div>
            <div class="item">修改密码</div>
            <div class="item">签到</div>
            <div class="item" onclick="window.location.href='/Logout'">退出</div></div>
<%--        </div>--%>
    </div>
    <iframe class="info" src="userInfo.jsp"></iframe>
</body>
</html>
