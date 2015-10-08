<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 09.10.15
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>

<body>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("username")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        session.invalidate();
        response.sendRedirect("/login");
    %>
</body>
</html>
