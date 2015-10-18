<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Student</td>
            <td>Class</td>
        </tr>
        <#list res as item>
            <tr>
                <#list item as i>
                    <td>${i}</td>
                </#list>
            </tr>
        </#list>
    </table>
</body>
</html>