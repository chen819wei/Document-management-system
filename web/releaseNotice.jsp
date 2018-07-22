<%@ page import="entity.Notice" %>
<%@ page import="dao.NoticeDao" %><%--
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
    <option value="行政部">行政部</option>
    <option value="财务部">财务部</option>
    <option value="质量管理部">质量管理部</option>
    <option value="技术部">技术部</option>
    <option value="人力资源部">人力资源部</option>
</select><br>
    <hr>
    正文:<br><textarea name="notice" cols="80" rows="30" align="center"></textarea>
    <br>
    <input type="submit" value="发布公文" style="width:200px;height: 30px;background:slategray"/>
</form>


</body>
</html>
