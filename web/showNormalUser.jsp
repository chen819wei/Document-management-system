<%@ page import="entity.NormalUser" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.NormalUserDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>普通用户管理</title>
</head>
<body>
<h1>普通用户管理</h1>
<hr>
<h3>普通用户列表</h3>
<%
    out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/addNormalUser.jsp' target='_blank'>");
    out.write("添加用户");
    out.write("</a>");
%><br>
<%
    List<NormalUser> normalUser = (List<NormalUser>) new NormalUserDao().selectAll();
    if (normalUser != null) {
        //取出每一个用户显示
        out.write("<ol>");
        for (NormalUser n : normalUser) {
            out.write("<li>");
            out.write("<span>");
            out.write("用户名:" + n.getUser_name() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "密码:" + n.getUser_password() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "所属部门:" + n.getDepartment());
            out.write("</span>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/DeleteNormalUserServlet?delete_id=" + n.getUser_id() + "'" + " target='_blank'>");
            out.write("删除");
            out.write("</a>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/changeNormalUser.jsp?change_id=" + n.getUser_id() + "'" + " target='_blank'>");
            out.write("修改");
            out.write("</a>");
            out.write("</li>");
        }
        out.write("</ol>");

    } else {
        out.write("没有用户");
    }
%>
</body>
</html>
