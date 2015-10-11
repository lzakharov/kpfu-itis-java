<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

    <#if error_msg??>
        <p>${error_msg}</p>
    </#if>

    <form name="login" action="/login" method="POST">
        <input name="username" type="text" <#if username??>value="${username}"</#if>><br>
        <input name="passwd" type="password"><br>
        <input name='checkbox' type='checkbox'>Remember me?<br><input name="submit" type="submit" value="Login">
    </form>
</body>
</html>