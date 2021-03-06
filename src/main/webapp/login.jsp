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
<div class="w3-container w3-center">
    <h1>User Login</h1>
    <form name="loginForm" action="loginAction.do?method=login" method="POST">
        <input type="text" name="username" placeholder="用户名">
        <input type="password" name="password" placeholder="密码">
        <img src="${pageContext.request.contextPath}/kaptcha" alt="kaptcha"/>
        <input type="text" name="captchaCode" placeholder="验证码" value=""/>
        <label>
            <input type="checkbox" name="rememberMe">记住我
        </label>
        <button value="Submit" type="submit" class="w3-btn w3-green">Submit</button>
    </form>
</div>

<script src="${pageContext.request.contextPath}/static/plugins/jq/1.3.2/jquery.min.js"></script>
</body>
</html>
