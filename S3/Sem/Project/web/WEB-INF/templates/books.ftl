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
        <#list books as book>
            <div class="book">
                <h2 class="book-name">${book.name}</h2>
                <p class="book-meta">${book.getAuthors()}</p>
                <a href="/book/show?id=${book.book_id}">Show</a>
            </div>
        </#list>
    </div>
</body>
</html>