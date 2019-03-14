<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Emp</title>
    <%--jsp获取项目名称 pageContext.request.contextPath--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/w3/w3.css"/>
</head>
<body>
<h1>Emp Manage</h1>
<a href="empAction.do?method=add">Add Emp</a>
<br/>
<a href="empAction.do?method=mockException">Mock Exception</a>
<br/>
<a href="javascript:void(1);" id="mockExAjax">Mock Exception Ajax</a>
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
                    <a href="empAction.do?method=delete&empno=${emp.empno}">Del</a>
                    <a href="empAction.do?method=edit&empno=${emp.empno}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<script src="${pageContext.request.contextPath}/static/plugins/jq/1.3.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/emp/index.js"></script>
</body>
</html>
