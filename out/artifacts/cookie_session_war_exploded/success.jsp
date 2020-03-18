<%--
  Created by IntelliJ IDEA.
  User: liujx
  Date: 2020/3/17
  Time: 上午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h><%=request.getSession().getAttribute("user")%>, 欢迎您</h>
</body>
</html>
