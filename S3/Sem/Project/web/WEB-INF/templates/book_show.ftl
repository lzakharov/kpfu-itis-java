<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <title></title>
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
        <div class="book-header">
            <h3>${book.name}</h3>
            <h4><a href="#">${book.getAuthors()}</a></h4>
        </div>
        <div class="row">
            <!-- Обложка книги -->
            <div class="col-md-3">
                <div class="cover">

                </div>
            </div>

            <!-- Основная информация -->
            <div class="col-md-9">
                <#if book.rate != 0><div class="rating">${book.rate}</div></#if>
                <div class="publication-info">
                    <#if book.year != 0>Год издания: ${book.year?c}</#if>
                    <br>
                    <#if book.publisher??>Издательство: ${book.publisher}</#if>
                </div>

                <div class="description">
                    <h2>Описание</h2>
                    <p>${book_data.description}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <#if current_user??>
            <div class="well">
                <h4>Leave a Review</h4>
                <form action="/leave-review" method="POST">
                    <div class="form-group">
                        <textarea class="form-control" id="text" name="text"></textarea>
                    </div>
                    <div class="form-group">
                        <select name="type">
                            <option selected value="1">Положительный отзыв</option>
                            <option value="2">Отрицательный отзыв</option>
                        </select>
                    </div>
                    <input type="hidden" name="book_id" value="${book.book_id}">
                    <input class="btn btn-primary btn-lg" type="submit" value="Отправить" >
                </form>
            </div>
        </#if>

        <hr>

        <#list reviews as review>
            <div class="media">
                <a class="pull-left" href="#">
                    <img class="media-object" src="http://placehold.it/64x64" alt="">
                </a>
                <div class="media-body" >
                    <h4 class="media-heading"> ${review.getAuthorName()}
                        <small>${review.timestamp}</small>
                    </h4>
                    <p class="alert-<#if review.type == 1>success<#else>danger</#if>">${review.text}</p>
                    <#if user_id?? && (user_id == review.author_id)>
                        <form action="/delete-review" method="post">
                            <p class="pull-right">
                                <input hidden name="review_id" value="${review.review_id}">
                                <input hidden name="author_id" value="${review.author_id}">
                                <input hidden name="book_id" value="${review.book_id}">
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
