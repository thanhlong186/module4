<%--
  Created by IntelliJ IDEA.
  User: thanhlong
  Date: 01/03/2022
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Calculator</h1>
  <form action="/calculate" method="post">
    <input type="text" name="no1" value="">
    <input type="text" name="no2" value="">
    <br>
    <br>
    <button type="submit" name="number" value="Addition (+)">Addition(+)</button>

    <button type="submit" name="number" value="Subtraction (-)">Subtraction(-)</button>

    <button type="submit" name="number" value="Multiplication (x)">Multiplication(x)</button>

    <button type="submit" name="number" value="Division (/)">Division(/)</button>
  </form>

${result}

  </body>
</html>
