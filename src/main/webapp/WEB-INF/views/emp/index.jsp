<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Emp</title>
    <link rel="stylesheet" href="../../../static/plugins/w3/w3.css"/>
</head>
<body>
<h1>Emp Manage</h1>
<a href="empAction.do?method=add">Add Emp</a>
<table>
    <tbody>
    <tr>
        <th>Empno</th>
        <th>Ename</th>
        <th>Opr</th>
    </tr>
    <c:if test="${empList != null}">
        <c:forEach items="${empList}" var="emp">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>
                    <a href="empAction.do?method=delete&empno=${emp.empno}">Del</a>&nbsp;&nbsp;
                    <a href="empAction.do?method=edit&empno=${emp.empno}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<script src="../../../static/plugins/w3/w3.js"></script>
</body>
</html>
