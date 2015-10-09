<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 09.10.15
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mult</title>
</head>

<body>
    <p>
    <%
        String requestArgs = request.getPathInfo();
        String[] args = requestArgs.substring(1).split("/");
    try {
        out.println(Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    %>
    </p>
</body>
</html>
