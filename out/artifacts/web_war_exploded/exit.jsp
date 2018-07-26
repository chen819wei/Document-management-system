<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/7/26
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exit</title>
</head>
<body>
<%session.invalidate();%>
<script language="javascript">window.open('${pageContext.request.contextPath}/index.jsp', '_top')</script>d

</body>
</html>
