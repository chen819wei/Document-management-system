<%@ page import="entity.Administrator" %>
<%@ page import="dao.AdministratorDao" %>
<%@ page import="entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DepartmentDao" %><%--
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
<h2>1、选择管理下列那类用户</h2>
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
<h2>2、管理部门</h2>
<li>
    <%
        out.write("<a href='" + request.getContextPath() + "/addDepartment.jsp' target='view_window'>");
        out.write("添加部门");
        out.write("</a>");
    %>
</li>
<ol>
    <%
        List<Department> department = (List<Department>) new DepartmentDao().selectAll();
        if (department != null) {
            //取出每一个用户显示
            out.write("<ol>");
            for (Department n : department) {
                out.write("<li>");
                out.write("<span>");
                out.write("部门名:" + n.getDepartment_name() );
                out.write("</span>");
                out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/DeleteDepartmentServlet?delete_id=" + n.getDepartment_id() + "'" + " target='_blank'>");
                out.write("删除");
                out.write("</a>");
                out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/changeDepartment.jsp?change_id=" + n.getDepartment_id() + "'" + " target='_blank'>");
                out.write("修改");
                out.write("</a>");
                out.write("</li>");
            }
            out.write("</ol>");

        } else {
            out.write("没有用户");
        }
    %>
</ol>
<script language="javascript">
    function exit() {
        if
        (confirm("您确定要退出登陆吗？")) {
            window.opener = null;
            window.open('${pageContext.request.contextPath}/exit.jsp', '_top')
            window.close();
        }
        else {
        }
    }
</script>
<input type="button" value="退出登陆" onclick="exit();"/>
</body>
</html>
