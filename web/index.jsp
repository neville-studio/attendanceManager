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
      }
      .inputText
      {
        width:100%;
        height:40px;
        margin: 8px auto;
      }
    </style>
  </head>
  <body>
  <div class="loginFrame">
    <form method="post">
    <table class="loginTable" width="100%">
      <caption>请先登录</caption>
      <tr>
    <td>account</td>
    <td><input type="text" class="inputText"></td></tr>
    <tr>
      <td>password</td>
    <td><input type="text" class="inputText"></td></tr></table>
      <div class="tip" id="tips"></div>
      <input type="submit">
    </form>
  </div>
  </body>
</html>
