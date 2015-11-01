<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <#include "user_nav.ftl">

    <div class="container">
        <div class="alert alert-danger alert-dismissible fade in" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <p id="error_msg"></p>
        </div>
        <!-- User information block -->
        <div class="user-info">
            <div class="row">
                <!-- User avatar -->
                <div class="col-md-4">
                    <div class="avatar-block">
                        <img id="avatar" src="">
                        <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <input type="file" id="exampleInputFile">
                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <form role="form" action="/change-info" id="info" method="POST">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h3 class="panel-title">Редактировать информацию</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="first_name">First name</label>
                                    <input type="text" class="form-control" id="first_name" name="first_name" value="${user.first_name}">
                                    <label for="last_name">Last name</label>
                                    <input type="text" class="form-control" id="last_name" name="last_name" value="${user.last_name}">
                                    <label for="address">Address</label>
                                    <input type="text" class="form-control" id="address" name="address" value="${user.address}">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control" id="email" name="email" value="${user.email}">
                                </div>
                                <button type="submit" class="btn btn-primary">Изменить</button>
                            </div>
                        </div>
                    </form>

                    <form role="form" action="change-password" id="change-password" method="POST">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h3 class="panel-title">Изменить пароль</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="password">Пароль</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                    <label for="password1">Повторите пароль</label>
                                    <input type="password" class="form-control" id="password1" placeholder="Password">
                                </div>
                                <button type="submit" class="btn btn-primary">Изменить пароль</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        // поля, обязательные для заполнения
        $('.alert').hide();

        $("#info").submit(function() {
            var error = 0;

            var email = $("#email").val();
            if (!isValidEmail(email)) {
                error = 2;
            }

            var birthdate = $("#birthdate").val();
            if (!isValidBirthdate(birthdate)) {
                error = 3;
            }

            var address = $("#address").val();
            if (!isValidAddress(address)) {
                error = 4;
            }

            if (error == 0) {
                return true;
            } else {
                if (error == 2) {
                    error_msg = "Введен некорректый email!";
                }
                if (error == 3) {
                    error_msg = "Введена некорректная дата рождения!";
                }
                if (error == 4) {
                    error_msg = "Введен некорректный адрес!";
                }

                $("#error_msg").html(error_msg);
                $('.alert').show();
                return false;
            }
        });

        $("#change-password").submit(function() {
            var error = 0;

            var passwd = $("#password").val();
            if (!isValidPassword(passwd)) {
                error = 1;
            }

            var passwd1 = $("#password1").val();
            if (passwd != passwd1) {
                error = 2;
            }

            if (error == 0) {
                return true;
            } else {
                var error_msg = "";
                if (error == 1) {
                    error_msg = "Введен некорректный пароль!"
                }
                if (error == 2) {
                    error_msg = "Введенные пароли не совпадают!"
                }

                $("#error_msg").html(error_msg);
                $('.alert').show();
                return false;
            }
        });


        function isValidEmail(email) {
            var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
            return pattern.test(email);
        }
        function isValidBirthdate(birthdate) {
            var pattern = new RegExp(/^\d{4}-\d{2}-\d{2}$/);
            return pattern.test(birthdate);
        }

        function isValidAddress(address) {
            var pattern = new RegExp(/([A-Z]([a-z]+)), ([A-Z]([a-z]+)), (\d{6}), (([A-Z]([a-z]+) )+)(\d{1,3}\/\d{1,4})/);
            return pattern.test(address);
        }

        function isValidPassword(passwd) {
            var pattern = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,}/);
            return pattern.test(passwd);
        }
    </script>
</body>
</html>