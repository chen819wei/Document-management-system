<%@ page import="dao.NoticeDao" %>
<%@ page import="entity.Notice" %>
<%@ page import="entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DepartmentDao" %><%--
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
</select><br>
<hr>
正文:<br><textarea name="notice" cols="80" rows="30" align="center"><%=notice.getNotice()%></textarea>
<br>
    <input type="submit" value="修改" style="width:200px;height: 30px;background:slategray"/>
    <input type="submit"  name="id" value="<%=notice.getNotice_id()%>" style="display: none"/>
</form>
</body>
</html>
