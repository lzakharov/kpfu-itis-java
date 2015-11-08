<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <#include "user_nav.ftl">

    <div class="container">
        <form name="article-new" action="/article/add" method="POST">
            <input type="text" class="form-control" placeholder="Title">
            <textarea class="form-control" rows="3" placeholder="Article description"></textarea>
            <textarea class="form-control" rows="3" placeholder="Text"></textarea>
            <button type="submit" class="btn btn-success">Добавить</button>
        </form>
    </div>
</div>
</body>
</html>