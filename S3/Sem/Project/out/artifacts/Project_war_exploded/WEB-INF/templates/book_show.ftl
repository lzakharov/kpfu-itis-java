<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>

<!-- Navigation -->
<!-- Navigation -->
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
                <button type="submit" class="btn btn-success">Вход</button>
                <button type="submit" class="btn btn-primary">Регистрация</button>
            </div>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<div class="container">
    <div class="book-header">
        <h3>${name}</h3>
        <h4><a href="#">${author}</a></h4>
    </div>
    <div class="row">
        <!-- Обложка книги -->
        <div class="col-md-3">
            <div class="cover">

            </div>
        </div>

        <!-- Основная информация -->
        <div class="col-md-9">
            <div class="rating">${rate}</div>
            <div class="publication-info">
                Год издания: ${year?c}
                <br>
                Издательство: ${publisher}
            </div>

            <div class="description">
                <h2>Описание</h2>
                <p>${description}</p>
            </div>
        </div>
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
                <h4 class="media-heading"> ${comment.name}
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
