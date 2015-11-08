<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feed</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css">
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
        <#list articles as article>
            <div class="article">
                <h2 class="article-title">${article.title}</h2>
                <p class="article-meta">Written by ${article.getAuthorName()} on ${article.timestamp}.</p>
                <p class="article-description">
                    ${article.description}
                </p>
                <a href="/article/show?id=${article.article_id}">Read more</a>
            </div>
        </#list>
    </div>
</body>
</html>