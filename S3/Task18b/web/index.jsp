<%--
  Created by IntelliJ IDEA.
  User: lzakharov
  Date: 21.10.15
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="application/javascript" src="js/jquery.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" value="student">Choose table
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a onclick="change('students')">Students</a></li>
            <li><a onclick="change('teachers')">Teachers</a></li>
            <li><a onclick="change('classes')">Classes</a></li>
        </ul>
        <input id="select" type="hidden" value="students" />
    </div>

    <input type="text" id="s" oninput="f()"/>

    <div id="res"></div>

    <script type="application/javascript">
        f = function (request, response) {
            $.ajax({
                url: "/search",
                data: {"q": $("#s").val(), "select": $("#select").val()},
                dataType: "json",
                success: function (data) {
                    if (data.results) {
                        $("#res").html("Search results:");
                        for (var i = 0; i < data.results.length; i++) {
                            $("#res").append("<li>" + data.results[i] + "</li>");
                        }
                    } else {
                        $("#res").html("No results");
                    }
                }
            });
        }

        f();
        
        change = function (param) {
            $("#select").val(param);
            f();
        }
    </script>
</body>
</html>
