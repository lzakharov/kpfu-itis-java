<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <title>Login</title>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <!-- Navigation-->
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Project name</a>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <div class="navbar-form navbar-right">
                    <a href="/login"><button type="submit" class="btn btn-success">Вход</button></a>
                    <a href="/registration"><button type="submit" class="btn btn-primary">Регистрацияa</button></a>
                </div>
            </div><!--/.navbar-collapse -->
        </div>
    </nav>

    <div class="container">
        <#if message??>
            <div class="alert alert-success">Вы успешно зарагистрировались, пожалуйста войдите!</div>
        </#if>
        <#if error_msg??>
            <div class="alert alert-danger">${error_msg}</div>
        </#if>

        <form class="form-login" action="/login" method="post">
            <h2 class="form-login-heading">Пожалйста войдите</h2>
            <label for="inputUsername" class="sr-only">Username</label>
            <input name="username" type="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox">
                <label>
                    <input name="checkbox" type="checkbox" value="remember-me"> Запомнить меня
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </form>
    </div>

</body>
</html>