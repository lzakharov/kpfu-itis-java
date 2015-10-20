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

    <#if current_user??>
        <#import "user_nav.ftl" as user_nav>
    <#else>
        <#import "anon_nav.ftl" as anon_nav>
    </#if>

    <div class="container">
        <div class="article">
            <div class="article-title">${article.title}</div>
            <p class="article-meta">Written by ${article.author} on ${article.date}</p>
            <div class="article-image">${article_data.image}</div>
            <p class="article-text">
                ${article_data.text}
            </p>
        </div>
    </div>

    <div class="container">
    <#if current_user??>
        <div class="well">
            <h4>Leave a Comment</h4>
            <div class="form-group">
                <textarea class="form-control"></textarea>
            </div>
            <a class="btn btn-primary btn-lg" href="#" role="button">Отправить</a>
        </div>
    </#if>

        <hr>

    <#list comments as comment>
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/64x64" alt="">
            </a>
            <div class="media-body">
                <h4 class="media-heading"> ${comment.author}
                    <small>${comment.time}</small>
                </h4>
                <p>${comment.text}</p>
                <p class="pull-right">
                    <a href="">Удалить</a>
                </p>
            </div>
        </div>
    </#list>
</div>
</body>
</html>