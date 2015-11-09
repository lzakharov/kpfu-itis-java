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
            <input type="text" name="title" class="form-control" placeholder="Title">
            <input hidden name="user_id" value="#{user_id}">
            <textarea name="description" class="form-control" rows="3" placeholder="Article description"></textarea>
            <textarea name="text" class="form-control" rows="3" placeholder="Text"></textarea>
            <input type="file" name="image" id="image">
            <button type="submit" class="btn btn-success">Add</button>
        </form>
    </div>
</div>
</body>
</html>