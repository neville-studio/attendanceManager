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
    <title>您好，<%=request.getSession().getAttribute("account").toString()%></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="StyleSheet/stylesheet.css">
</head>
<body>
    <div class="title">
<%--        <div class="menu">--%>
            <div class="left">
            <div class="item" id="userInfo">首页</div>
            <div class="item" id="getAllRecords">查询记录</div>
                <%if(request.getSession().getAttribute("user_type").toString().equals("2")){%><div class="item" id="managePeople">管理人员</div><%}%>
                <%if(!request.getSession().getAttribute("user_type").toString().equals("0")){%><div class="item" id="manageAttendance">管理签到时间</div><%}%>
            </div><div class="right">
            <div class="item" id="changeUser"><%=request.getSession().getAttribute("account").toString()%></div>
            <div class="item" id="changePw">修改密码</div>
            <%if(request.getSession().getAttribute("user_type").toString().equals("0")){%><div class="item" id="getTime">签到</div><%}%>
            <div class="item" onclick="window.location.href='/Logout'">退出</div></div>
<%--        </div>--%>
    </div>
    <iframe class="info" id="infoFrame" src="userInfo.jsp"></iframe>
<script>
    if(document.getElementById("userInfo")!=null) {
        document.getElementById("userInfo").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/userInfo.jsp');
        })
    }
    if(document.getElementById("changeUser")!=null) {
        document.getElementById("changeUser").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/changeUser.jsp')
        })
    }
    if(document.getElementById("changePw")!=null) {
        document.getElementById("changePw").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/changePassword.jsp')
        })
    }
    if(document.getElementById("managePeople")!=null) {
        document.getElementById("managePeople").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/ManageUser.jsp')
        })
    }
    if(document.getElementById("manageAttendance")!=null) {
        document.getElementById("manageAttendance").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/ManageAttendance.jsp')
        })
    }
    if(document.getElementById("getAllRecords")!=null) {
        document.getElementById("getAllRecords").addEventListener("click", () => {
            document.getElementById("infoFrame").setAttribute('src', '/recordManage.jsp')
        })
    }




    let Http = new XMLHttpRequest();
    Http.onreadystatechange = (e) => {
        let orgData = JSON.parse(Http.responseText);
        console.log(orgData)
        document.getElementById("getTime").innerHTML=orgData.status;
        if(!orgData.enable)document.getElementById("getTime").setAttribute("class","disabledItem");
        else document.getElementById("getTime").setAttribute("class","item");
    }
    window.onload= function () {
        if (document.getElementById("getTime") != null) {
            Http.open("GET", "/Sign");
            Http.send();
        }

    }

    setInterval(()=>
    {
        if(new Date().getSeconds()==0)
        {
            if(document.getElementById("getTime")!=null){

                let url='/Sign';
                Http.open("GET", url);
                Http.send();
            }
        }
    },500);
    if(document.getElementById("getTime")!=null) {
        document.getElementById("getTime").addEventListener("click", () => {
            if(document.getElementById("getTime").getAttribute("class")=="item") {
                let url = '/Sign?method=go';
                Http.open("GET", url);
                Http.send();
            }
        })
    }
</script>
</body>
</html>
