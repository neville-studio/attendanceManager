<%--
  Created by IntelliJ IDEA.
  User: 28407
  Date: 2022/12/12
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>您好，请先登录</title>
    <meta charset="utf-8">
    <style>
      html{
        height: 100%;
      }
      body{
        height: 100%;
        margin: 0;
        background-image: linear-gradient(60deg,rgba(218, 169, 215, 0.637),rgba(128, 174, 235, 0.904));
      }
      .loginFrame
      {
        width:300px;
        height: 200px;
        position: absolute;
        left:calc(100% / 2 - 150px);
        top:calc(100% / 2 - 100px);
        border:1px solid gray;
        border-radius: 8px;
        text-align: center;
        padding: 16px;
        background-color: rgba(255,255,255,0.8);
        box-shadow: #eee;
      }
      .inputText
      {
        width:100%;
        height:32px;
        margin: 8px auto;
      }
      #title{
        font-family: "Times New Roman", "Kaiti", "Segoe UI", serif;
        font-size: 32px;
      }
      .button{
        background-color:#4CAF50;
        border:2px solid #4CAF50;
        border-radius:  4px;
        padding:4px 24px;
        transition-duration: 300ms;
        color:white;
      }
      .button:hover
      {
        background-color:white;
        color:black;
      }
    </style>
  </head>
  <body>
  <div class="loginFrame" >
    <form method="post" action="/Auth" id="loginForm">
    <table class="loginTable" width="100%">
      <caption id="title">请先登录</caption>
      <tr>
    <td>账户</td>
    <td><input type="text" class="inputText" name="account"></td></tr>
    <tr>
      <td>密码</td>
      <td><input type="password" class="inputText" value="登录" name="password"></td></tr></table>
      <div class="tip" id="tips">&nbsp;
        <%
          String result = request.getParameter("errortype");
          if(result!=null)out.println("用户名或者密码错误！");
        %>

      </div>
      <button type="submit" class="button">登录</button>
    </form>
  </div>
  <script>

  </script>
  </body>
</html>
