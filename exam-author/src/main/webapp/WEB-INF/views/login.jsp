<%--
  Created by IntelliJ IDEA.
  User: mmc
  Date: 2017/11/28
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

    <form name="loginForm" action="login" method="post">

        USERNAME：<input type="text" name="userName" id="UserName" />
        <br/><br/>

        PASSWORD：<input type="password" name="password" id="password"/>
        <br/><br/>

        <input type="submit" value="login"/>
    </form>
</body>
</html>
