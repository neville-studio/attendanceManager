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
    <title>$Title$</title>
    <style>
      html{
        height: 100%;
      }
      body{
        height: 100%;
        margin: 0;
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
      }
      .inputText
      {
        width:100%;
        height:32px;
        margin: 8px auto;
      }
      #title{
        font-family: "Times New Roman","Kaiti","Segoe UI";
        font-size: 32px;
      }
    </style>
  </head>
  <body>
  <div class="loginFrame" >
    <form method="post" action="/Auth">
    <table class="loginTable" width="100%">
      <caption id="title">请先登录</caption>
      <tr>
    <td>账户</td>
    <td><input type="text" class="inputText"></td></tr>
    <tr>
      <td>密码</td>
      <td><input type="password" class="inputText" value="登录"></td></tr></table>
      <div class="tip" id="tips"></div>
      <button type="submit">登录</button>
    </form>
  </div>
  <script>

  </script>
  </body>
</html>
