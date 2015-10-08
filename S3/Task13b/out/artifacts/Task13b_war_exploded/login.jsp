<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 08.10.15
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>

<%!
    HashMap<String, String> users = new HashMap<>();

    private void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("username".equals(cookie.getName())) {
                    request.getSession().setAttribute("current_user", cookie.getValue());
                }
            }
        }
    }
%>

<body>
    <%
        users.put("lev", "123");
        getCookies(request);
        if (session.getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        }

        if (request.getMethod().equals("POST")) {
            String username = request.getParameter("username");

            if (request.getParameter("passwd").equals(users.get(username))) {
                session.setAttribute("current_user", username);
                if (request.getParameter("checkbox") != null) {
                    Cookie cookie = new Cookie("username", username);
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                response.sendRedirect("/profile");
            } else {
                if (!users.containsKey(username)) {
                    response.sendRedirect("/login?error_msg=Wrong%20username&username=" + username);
                }
                if (users.containsKey(username) && !users.get(username).equals(request.getParameter("passwd"))) {
                    response.sendRedirect("/login?error_msg=Wrong%20password&username=" + username);
                }
            }
        }
    %>

    <%
        if (request.getParameter("error_msg") != null) {
            out.println("<p>" + request.getParameter("error_msg") + "</p>");
        }
    %>

    <form name="login" action="/login" method="POST">
        <input name="username" type="text" <%= request.getParameter("username") != null ? "value" + request.getParameter("username"): "" %>><br>
        <input name="passwd" type="password"><br>
        <input name='checkbox' type='checkbox'>Запомнить?<br><input name="submit" type="submit" value="Login">
    </form>

</body>
</html>
