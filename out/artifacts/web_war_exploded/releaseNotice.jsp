<%@ page import="java.util.List" %>
<%@ page import="entity.*" %>
<%@ page import="dao.*" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/21
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--发布公文--%>
<html>
<head>
    <title>发布公文</title>
</head>
<body>
<form action="ReleaseNoticeServlet" method="post">
    标题:<input type="text" name="title" value=""/>
    部门:<select name="department">
    <option value="全部部门">全部部门</option>
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
    选择谁可见:<select name="people">
    <option></option>
    <%
        List<NormalUser> normalUsers = (List<NormalUser>) new NormalUserDao().selectAll();
        if (normalUsers != null) {
            for (NormalUser n : normalUsers) {

                out.write("<option>");
                out.write(n.getUser_name() );
                out.write("</option>");

            }
        } else {
            out.write("没有用户");
        }
        List<AdminUser> adminUser = (List<AdminUser>) new AdminUserDao().selectAll();
        if (normalUsers != null) {
            for (AdminUser n : adminUser) {

                out.write("<option>");
                out.write(n.getUser_name() );
                out.write("</option>");

            }
        } else {
            out.write("没有用户");
        }
    %>
</select>

    <br>
    <hr>
    正文:<br><textarea name="notice" cols="80" rows="30" align="center"></textarea>
    <br>
    <input type="submit" value="发布公文" style="width:200px;height: 30px;background:slategray"/>
</form>


</body>
</html>
