<%@ page import="entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DepartmentDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加普通用户</title>
</head>
<body>
<form action="AddNormalUserServlet" method="post">
    账号:<input type="text" name="account" value=""/>
    密码:<input type="text" name="password" value=""/>
    部门:<select name="department">
    <%
        List<Department> department = (List<Department>) new DepartmentDao().selectAll();
        if (department != null) {
            for (Department n : department) {
                out.write("<li>");
                out.write("<option>");
                out.write(n.getDepartment_name() );
                out.write("</option>");
                out.write("</li>");
            }


        } else {
            out.write("没有用户");
        }
    %>
</select>

    <hr>
    <input type="submit" value="添加用户" style="width:200px;height: 30px;background:slategray"/>
</form>

</body>
</html>
