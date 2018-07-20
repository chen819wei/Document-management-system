<%@ page import="dao.NormalUserDao" %>
<%@ page import="entity.NormalUser" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户</title>
</head>
<body>
<h1>普通用户</h1>
<%NormalUser normal= (NormalUser) request.getAttribute("user_name");%>

<%NormalUser normalUser=new NormalUserDao().select(normal.getUser_name());%>
账号:<%= normalUser.getUser_name()%> <br>
部门:<%= normalUser.getDepartment()%><br>

<hr>




</body>
</html>
