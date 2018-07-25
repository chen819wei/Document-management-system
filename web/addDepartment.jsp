<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/25
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<form action="addDepartmentServlet" method="post">
    <div align="left">
        部门名:<input type="text" name="department_name"/><br>
        <input type="submit" value="添加"/>
    </div>

</body>
</html>
