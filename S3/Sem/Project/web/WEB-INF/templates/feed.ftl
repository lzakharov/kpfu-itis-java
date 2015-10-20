<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feed</title>
</head>
<body>
    <#if current_user??>
        <#import "user_nav.ftl" as user_nav>
    <#else>
        <#import "anon_nav.ftl" as anon_nav>
    </#if>

    <div class="jumbotron">
        <div class="container">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="container">
        <#list articles as article>
            <div class="article">
                <h2 class="article-title">${article.title}</h2>
                <p class="article-meta">Written by ${article.author} on ${article.date}.</p>
                <p class="article-description">
                    ${article.description}
                </p>
                <a href="/article/show?id=${article.id}"Read more</a>
            </div>
        </#list>
    </div>
</body>
</html>