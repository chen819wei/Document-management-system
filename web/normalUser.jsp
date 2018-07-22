<%@ page import="dao.NormalUserDao" %>
<%@ page import="entity.NormalUser" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Notice" %>
<%@ page import="java.sql.SQLOutput" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--普通用户信息显示界面--%>
<html>
<head>
    <title>普通用户</title>
</head>
<body>
<h1>普通用户</h1>
<%NormalUser normal = (NormalUser) request.getAttribute("user_name");%>
<%NormalUser normalUser = new NormalUserDao().select(normal.getUser_name());%>
账号:<%= normalUser.getUser_name()%> <br>
部门:<%= normalUser.getDepartment()%><br>
<hr>
<h3>公文列表</h3><br>
<%
    List<Notice> notices = (List<Notice>) request.getAttribute("department");
    if (notices != null) {
        //取出每一个公文显示
        out.write("<ol>");
        for (Notice n : notices) {
            out.write("<li>");
            out.write("<a href='" + request.getContextPath() + "/noticeShow.jsp?name=" + n.getNotice_id() + "'" + " target='view_window'>");
            out.write("标题:" + n.getTitle() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "部门:" + n.getDepartment() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "发布时间:" + n.getRelease_time());
            out.write("</a>");
            out.write("</li>");
        }
        out.write("</ol>");

    } else {
        out.write("没有公文");
    }
%>


</body>
</html>
