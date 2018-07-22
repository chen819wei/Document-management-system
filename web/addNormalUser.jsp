<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/22
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加普通用户</title>
</head>
<body>
<form action="AddNormalUserServlet" method="post">
    账号:<input type="text" name="account" value=""/>
    密码:<input type="text" name="password" value=""/>
    部门:<select name="department">
    <option value="行政部">行政部</option>
    <option value="财务部">财务部</option>
    <option value="质量管理部">质量管理部</option>
    <option value="技术部">技术部</option>
    <option value="人力资源部">人力资源部</option>
</select>
    <hr>
    <input type="submit" value="添加用户" style="width:200px;height: 30px;background:slategray"/>
</form>

</body>
</html>
