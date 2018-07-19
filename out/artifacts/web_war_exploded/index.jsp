<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>公文管理系统</title>
</head>
<body>
<hr>
<h1 align="left">公文管理系统登录</h1>
<hr>
<form action="LogInServlet" method="post">
  <div align="left">
    账号:<input type="text" name="user_name"/><br>
    密码:<input type="password" name="user_password"/><br>
    <input type="radio" name="user" value="普通用户" checked="checked"/>普通用户<br>
    <input type="radio" name="user" value="公文管理用户"/>公文管理用户<br>
    <input type="radio" name="user" value="管理员" />管理员<br>
    <input type="submit" value="登录"/>
  </div>



</form>
</body>
</html>