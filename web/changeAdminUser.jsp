<%@ page import="entity.AdminUser" %>
<%@ page import="dao.AdminUserDao" %>
<%@ page import="entity.Department" %>
<%@ page import="dao.DepartmentDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改文件管理用户信息</title>
</head>
<body>
<form action="ChangeAdminUserServlet" method="post">
    <%int i= Integer.parseInt(request.getParameter("change_id"));
        AdminUser adminUser=new AdminUserDao().select(i);
    %>
    账号:<input type="text" name="account" value="<%=adminUser.getUser_name()%>"/>
    密码:<input type="text" name="password" value="<%=adminUser.getUser_password()%>"/>
    <input type="text"  name="id" value="<%=adminUser.getAdminUser_id()%>" style="display: none"/>
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
    <input type="submit" value="修改" style="width:200px;height: 30px;background:slategray"/>
</form>

</body>
</html>
