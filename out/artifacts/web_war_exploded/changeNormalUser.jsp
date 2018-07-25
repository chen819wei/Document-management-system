<%@ page import="entity.NormalUser" %>
<%@ page import="dao.NormalUserDao" %>
<%@ page import="entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DepartmentDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<form action="ChangeNormalUserServlet" method="post">
    <%int i= Integer.parseInt(request.getParameter("change_id"));
        NormalUser normalUser=new NormalUserDao().select(i);
    %>
    账号:<input type="text" name="account" value="<%=normalUser.getUser_name()%>"/>
    密码:<input type="text" name="password" value="<%=normalUser.getUser_password()%>"/>
    <input type="text"  name="id" value="<%=normalUser.getUser_id()%>" style="display: none"/>
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
