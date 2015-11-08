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
        <#include "user_nav.ftl">
    <#else>
        <#include "anon_nav.ftl">
    </#if>

    <div class="container">
        <div class="article">
            <div class="article-title"><h2>${article.title}</h2></div>
            <p class="article-meta">Written by ${article.getAuthorName()} on ${article.timestamp}</p>
            <div class="article-image">
                <#if article_data.image??>
                    ${article_data.image}
                <#else>
                    IMAGE
                </#if>
            </div>
            <p class="article-text">
                ${article_data.text}
            </p>
        </div>
    </div>

    <div class="container">
    <#if current_user??>
        <div class="well">
            <h4>Leave a comment</h4>
            <form action="/leave-comment" method="POST">
                <div class="form-group">
                    <textarea class="form-control" id="text" name="text"></textarea>
                </div>
                <input type="hidden" name="article_id" value="${article.article_id}">
                <input class="btn btn-primary btn-lg" type="submit" value="Отправить" >
            </form>
        </div>
    </#if>

    <hr>

    <#list comments as comment>
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/64x64" alt="">
            </a>
            <div class="media-body">
                <h4 class="media-heading"> ${comment.getAuthorName()}
                    <small>${comment.timestamp}</small>
                </h4>
                <p>${comment.text}</p>
                <#if user_id?? && (user_id == comment.author_id)>
                    <form action="/delete-comment" method="POST">
                        <p class="pull-right">
                            <input hidden name="comment_id" value="${comment.comment_id}">
                            <input hidden name="author_id" value="${comment.author_id}">
                            <input hidden name="article_id" value="${comment.article_id}">
                            <input class="btn btn-link" type="submit" value="Удалить">
                        </p>
                    </form>
                </#if>
            </div>
        </div>
    </#list>
</div>
</body>
</html>