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
      }
      .loginFrame
      {
        width:300px;
        height:200px;
      }
    </style>
  </head>
  <body>
  <div class="loginFrame">
    <form method="post">
    <table class="loginTable">
      <tr>
    <td>account</td>
    <td><input type="text"></td></tr>
    <tr>
      <td>password</td>
    <td><input type="text"></td></tr></table>
      <div class="tip" id="tips"></div>
      <input type="submit">
    </form>
  </div>
  </body>
</html>
