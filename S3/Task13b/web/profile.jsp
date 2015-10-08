<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 09.10.15
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <p>Hi, <%= session.getAttribute("current_user")%>!</p>
    <a href="/logout">Logout</a>
</body>
</html>
