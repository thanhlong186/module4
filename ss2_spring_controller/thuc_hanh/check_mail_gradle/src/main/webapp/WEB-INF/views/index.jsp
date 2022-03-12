<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 01/03/2022
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email Validate</title>
  </head>
  <body>
<h1>Email Validate</h1>
<h3 style="color: cornflowerblue">${message}</h3>
<form action="validate" method="post">
    <input type="text" name="email">
    <input type="submit" value="Validate">
</form>
  </body>
</html>
