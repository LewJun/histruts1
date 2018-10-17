<%--
  Created by IntelliJ IDEA.
  User: lewjun
  Date: 10/18/18
  Time: 4:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Add</title>
</head>
<body>
<form action="empAction.do?method=save" method="post">
    <label for="empno">Empno:</label><input id="empno" type="text" name="empno"/>
    <label for="ename">Ename:</label><input id="ename" type="text" name="ename"/>

    <input type="submit" value="save">
</form>
</body>
</html>
