<%@ page import="entity.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.AdminUser" %>
<%@ page import="dao.AdminUserDao" %>
<%@ page import="dao.NoticeDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/21
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公文管理用户</title>
</head>
<body>
<h1>公文管理用户</h1>
<%AdminUser normal = (AdminUser) request.getAttribute("adminUser");%>
<%AdminUser adminUser = new AdminUserDao().select(normal.getUser_name());%>
账号:<%= adminUser.getUser_name()%> <br>
部门:<%= adminUser.getDepartment()%><br>
<hr>
<h3>公文列表</h3>
<%
    out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/releaseNotice.jsp' target='view_window'>");
    out.write("发布公文");
    out.write("</a>");
%><br>
<h5>公开公文</h5>
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
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/DeleteServlet?delete_id=" + n.getNotice_id() + "'"+ ">" );
            out.write("删除");
            out.write("</a>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/noticeChange.jsp?change_id=" + n.getNotice_id() + "'" + " target='view_window'>");
            out.write("修改");
            out.write("</a>");
            out.write("</li>");
        }
        out.write("</ol>");

    } else {
        out.write("没有公文");
    }

%>
<h5>仅本人可见</h5>
<%
List<Notice> notices1 = new NoticeDao().selectAll(adminUser.getDepartment(),adminUser.getUser_name());
    if (notices1 != null) {
    //取出每一个公文显示
    out.write("<ol>");
        for (Notice n : notices1) {
        out.write("<li>");
            out.write("<a href='" + request.getContextPath() + "/noticeShow.jsp?name=" + n.getNotice_id() + "'" + " target='view_window'>");
            out.write("标题:" + n.getTitle() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
            + "可见人员:" + n.getPeople() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
            + "发布时间:" + n.getRelease_time());
            out.write("</a>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/DeleteServlet?delete_id=" + n.getNotice_id() + "'"+ ">" );
            out.write("删除");
            out.write("</a>");
            out.write("&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "<a href='" + request.getContextPath() + "/noticeChange.jsp?change_id=" + n.getNotice_id() + "'" + " target='view_window'>");
            out.write("修改");
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
