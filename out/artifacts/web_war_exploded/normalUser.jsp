<%@ page import="dao.NormalUserDao" %>
<%@ page import="entity.NormalUser" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Notice" %>
<%@ page import="java.sql.SQLOutput" %>
<%@ page import="dao.NoticeDao" %><%--
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
<h5>公开公文</h5>

<%
    //List<Notice> notices = new NoticeDao().selectAll((String) request.getAttribute("department"));
    //List<Notice> notices = (List<Notice>) request.getAttribute("department");
    List<Notice> notices = new NoticeDao().selectAll(normal.getDepartment(),normalUser.getUser_name());
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


    } else {
        out.write("没有公文");
    }%>
<h5>仅本人可见</h5>

<%
    List<Notice> notices1 = new NoticeDao().selectAll(normal.getDepartment());
    if (notices1 != null) {
        //取出每一个公文显示

        for (Notice n : notices1) {
            out.write("<li>");
            out.write("<a href='" + request.getContextPath() + "/noticeShow.jsp?name=" + n.getNotice_id() + "'" + " target='view_window'>");
            out.write("标题:" + n.getTitle() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "可见人员:" + n.getPeople() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
                    + "发布时间:" + n.getRelease_time());
            out.write("</a>");
            out.write("</li>");
        }
        out.write("</ol>");

    } else {
        out.write("没有公文");
    }
%>
<script language="javascript">
    function exit() {
        if
        (confirm("您确定要退出登陆吗？")) {
            window.opener = null;
            window.open('${pageContext.request.contextPath}/index.jsp', '_top')
            window.close();
        }
        else {
        }
    }
</script>
<input type="button" value="退出登陆" onclick="exit();"/>


</body>
</html>
