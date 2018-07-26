<%@ page import="entity.Notice" %>
<%@ page import="dao.NoticeDao" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/21
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--显示公文详情--%>
<html>
<head>
    <title>公文详情显示</title>
</head>
<body>
<%int i= Integer.parseInt(request.getParameter("name"));
    Notice notice = new NoticeDao().select(i);
    out.write("<li style='list-style-type:none;'>");
    out.write("<p>");
    out.write("标题:" + notice.getTitle() + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
            + "部门:" + notice.getDepartment()+ "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp" + "&nbsp"
            + "发布时间:"+notice.getRelease_time());
    out.write("</p>");
    out.write("<hr>");
    out.write("<p>");
    out.write("正文："+notice.getNotice());
    out.write("</p>");
    out.write("</li>");

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
