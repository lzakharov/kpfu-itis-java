<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: levzaharov
  Date: 09.10.15
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>

<%!
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    Date date = new Date();
%>

<body>
    <%= dateFormat.format(date) %>
</body>
</html>
