<%--
  Created by IntelliJ IDEA.
  User: sephiroth
  Date: 2018/2/5
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form method="post" action="/user/login">
        <label>用户名：</label>
        <input type="text" name="username" /><br>
        <label>密码：</label>
        <input type="text" name="password" /><br>
        <input type="submit" value="login">
    </form>
</body>
</html>
