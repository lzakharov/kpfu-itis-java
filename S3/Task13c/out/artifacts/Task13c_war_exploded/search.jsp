<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 09.10.15
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

    <%
        String action = null;
        String input = null;
        switch (request.getPathInfo().substring(1)) {
            case "baidu":
                action = "http://www.baidu.com/s";
                input = "wd";
                break;
            case "bing":
                action = "http://www.bing.com/search";
                input = "q";
                break;
            case "yahoo":
                action = "https://search.yahoo.com/search";
                input = "p";
                break;
            case "aol":
                action = "http://search.aol.com/aol/search";
                input = "q";
                break;
            default:
                response.sendError(404, "Bad request");
        }
    %>

    <form name="search" action="<%= action %>">
        <input type="text" name="<%= input %>">
        <input type="submit" value="Search!">
    </form>
</body>
</html>
