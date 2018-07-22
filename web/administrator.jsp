<%@ page import="entity.Administrator" %>
<%@ page import="dao.AdministratorDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/21
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
管理员
--%>
<html>
<head>
    <title>管理员</title>
</head>
<body>
<h1>管理员</h1>
<%Administrator administrator1 = (Administrator) request.getAttribute("administrator");%>
<%Administrator administrator = new AdministratorDao().select(administrator1.getUser_name());%>
账号:<%= administrator.getUser_name()%> <br>
<hr>
<h2>选择管理下列那类用户</h2>
<ol>
    <li><%
        out.write("<a href='" + request.getContextPath() + "/showNormalUser.jsp' target='view_window'>");
        out.write("普通用户");
        out.write("</a>");
    %></li>
    <li>
        <%
            out.write("<a href='" + request.getContextPath() + "/showAdminUser.jsp' target='view_window'>");
            out.write("公文管理用户");
            out.write("</a>");
        %>
    </li>
</ol>
</body>
</html>
