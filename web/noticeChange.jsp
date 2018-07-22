<%@ page import="dao.NoticeDao" %>
<%@ page import="entity.Notice" %><%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公文</title>
</head>
<body>
<form action="NoticeChangeServlet" method="post">
<%int i= Integer.parseInt(request.getParameter("change_id"));
    Notice notice=new NoticeDao().select(i);
%>
标题:<input type="text" name="title" value="<%=notice.getTitle()%>"/>
    <input type="text"  name="id" value="<%=notice.getNotice_id()%>" style="display: none"/>
部门:<select name="department">
    <option value="全部部门">全部部门</option>
    <option value="行政部">行政部</option>
    <option value="财务部">财务部</option>
    <option value="质量管理部">质量管理部</option>
    <option value="技术部">技术部</option>
    <option value="人力资源部">人力资源部</option>
</select><br>
<hr>
正文:<br><textarea name="notice" cols="80" rows="30" align="center"><%=notice.getNotice()%></textarea>
<br>
    <input type="submit" value="修改" style="width:200px;height: 30px;background:slategray"/>
    <input type="submit"  name="id" value="<%=notice.getNotice_id()%>" style="display: none"/>
</form>
</body>
</html>
