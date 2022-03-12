<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 28/02/2022
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Vietnamese Dictionary</h1>
  <form method="post">
    <input type="text" name="search" placeholder="Enter your word">
    <input type="submit" id = "submit" value="search">
  </form>
<p>Kết quả bạn cần tìm là : ${result}</p>
  </body>
</html>
