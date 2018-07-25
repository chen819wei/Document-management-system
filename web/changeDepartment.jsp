<%@ page import="dao.DepartmentDao" %>
<%@ page import="entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/25
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>
<form action="ChangeDepartmentServlet" method="post">
        <%int i= Integer.parseInt(request.getParameter("change_id"));
        Department department=new DepartmentDao().select(i);
    %>
    部门:<input type="text" name="account" value="<%=department.getDepartment_name()%>"/>
            <input type="text"  name="id" value="<%=department.getDepartment_id()%>" style="display: none"/>
    <hr>
    <input type="submit" value="修改" style="width:200px;height: 30px;background:slategray"/>

</body>
</html>
