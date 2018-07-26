<%@ page import="entity.AdminUser" %>
<%@ page import="dao.AdminUserDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件管理用户</title>
</head>
<body>
<h1>文件管理用户</h1>
<hr>
<h3>文件管理用户列表</h3>
<%
    out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/addAdminUser.jsp' target='_blank'>");
    out.write("添加用户");
    out.write("</a>");
%><br>
<%
    List<AdminUser> adminUser = (List<AdminUser>) new AdminUserDao().selectAll();
    if (adminUser != null) {
        //取出每一个用户显示
        out.write("<ol>");
        for (AdminUser n : adminUser) {
            out.write("<li>");
            out.write("<span>");
            out.write("用户名:" + n.getUser_name() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "密码:" + n.getUser_password() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "所属部门:" + n.getDepartment());
            out.write("</span>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/DeleteAdminUserServlet?delete_id=" + n.getAdminUser_id() + "'" + " target='_blank'>");
            out.write("删除");
            out.write("</a>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/changeAdminUser.jsp?change_id=" + n.getAdminUser_id() + "'" + " target='_blank'>");
            out.write("修改");
            out.write("</a>");
            out.write("</li>");
        }
        out.write("</ol>");

    } else {
        out.write("没有用户");
    }
%>
<hr>
<script language="javascript">
    function exit() {
        window.close();
    }
</script>
<input type="button" value="退出" onclick="exit();"/>

</body>
</html>
