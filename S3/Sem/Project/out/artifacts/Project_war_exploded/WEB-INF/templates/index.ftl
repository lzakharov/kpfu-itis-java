<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
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

    <div class="jumbotron">
        <div class="container">
            <h1>Hello, world!</h1>
            <p id="res">This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h1>Новости</h1>
                <div id="articles">

                </div>
                <!-- Pagination -->
                <nav>
                    <ul class="pagination">
                        <li><a id="previous" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        <li><a id="next" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </ul>
                </nav>
            </div>

            <script type="application/javascript">
                f = function (page_num) {
                    $.ajax({
                        url: "/pagination",
                        data: {"page_num": page_num},
                        dataType: "json",
                        success: function (data) {
                            $("#articles").html("");
                            if (data.results) {
                                for (var i = 0; i < data.results.length; i++) {
                                    $("#articles").append(
                                            "<div class='article'>" +
                                                    "<h2 class='article-title'>" + data.results[i].title + "</h2>" +
                                                    "<p class='article-meta'>Written by " + data.results[i].author_name + " on " + data.results[i].timestamp.substring(0, 10) + ".</p>" +
                                                    "<p class='article-description'>" + data.results[i].description + "</p>" +
                                                    "<a href='/article/show?id=" + data.results[i].article_id + ">Read more</a>" +
                                            "</div>"
                                    );
                                }
                            }
                        }
                    })
                };
                var page_num = 1;
                $("#previous").click(function() {
                    if (page_num > 1) {
                        page_num--;
                    }
                    f(page_num);
                });
                $("#next").click(function() {
                    if (page_num < ${max_page}) {
                        page_num++;
                    }
                    f(page_num);
                });
                f(page_num);

            </script>


            <div class="col-md-3">
                <div class="panel panel-primary">
                    <div class="panel-heading"><h6>Последние новости</h6></div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Title</th>
                                <th>Author</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list last_articles as article>
                                    <tr>
                                        <th scope="row"><a href="/article/show?id=${article.article_id}">${article.title}</a></th>
                                        <td>${article.getAuthorName()}</td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="panel panel-success">
                    <div class="panel-heading"><h6>Топ книг</h6></div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Title</th>
                                <th>Author</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list last_books as book>
                            <tr>
                                <th scope="row"><a href="/book/show?id=${book.book_id}">${book.name}</a></th>
                                <td>${book.getAuthors()}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
