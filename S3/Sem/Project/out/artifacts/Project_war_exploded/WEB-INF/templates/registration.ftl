<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css"/>
</head>
<body>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <#include "anon_nav.ftl">

    <div class="container">
        <div class="alert alert-danger alert-dismissible fade in" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <p id="error_msg"></p>
        </div>

        <form id="registration-form" class="form-horizontal" action="/registration" method="POST">
            <div class="form-group" id="username-group">
                <div class="col-md-4">
                    <label class="control-label"  for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" <#if username??>value="${username}"</#if> >
                    <span class="help-block">Username can contain any letters or numbers, without spaces.</span>
                </div>
            </div>
            <div class="form-group" id="email-group">
                <div class="col-md-4">
                    <label class="control-label"  for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" <#if email??>value="${email}"</#if> >
                    <span class="help-block">Please provide your E-mail.</span>
                </div>
            </div>
            <div class="form-group" id="first_name-group">
                <div class="col-md-4">
                    <label class="control-label"  for="first_name">First name</label>
                    <input type="text" class="form-control" id="first_name" name="first_name" <#if first_name??>value="${first_name}"</#if> >
                    <span class="help-block">Please provide your first name.</span>
                </div>
            </div>
            <div class="form-group" id="last_name-group">
                <div class="col-md-4">
                    <label class="control-label"  for="last_name">Last name</label>
                    <input type="text" class="form-control" id="last_name" name="last_name" <#if last_name??>value="${last_name}"</#if> >
                    <span class="help-block">Please provide your last name.</span>
                </div>
            </div>
            <div class="form-group" id="birthdate-group">
                <div class="col-md-4">
                    <label class="control-label"  for="birthdate">Birthdate</label>
                    <input type="text" class="form-control" id="birthdate" name="birthdate" >
                    <span class="help-block">Please provide your birthdate. Example: 1999-12-31</span>
                </div>
            </div>
            <div class="form-group" id="address-group">
                <div class="col-md-4">
                    <label class="control-label"  for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" >
                    <span class="help-block">Please provide your address. Please follow this format: Country, City, index, Street ?/? </span>
                </div>
            </div>
            <div class="form-group" id="password-group">
                <div class="col-md-4">
                    <label class="control-label"  for="password">Password</label>
                    <input type="text" class="form-control" id="password" name="password" >
                <span class="help-block">Please provide your password.  Password must be six characters including one uppercase letter, one lower character and alphanumeric characters.</span>
                </div>
            </div>
            <div class="form-group" id="password1-group">
                <div class="col-md-4">
                    <label class="control-label"  for="password1">Repeat password</label>
                    <input type="text" class="form-control" id="password1" name="password1" >
                    <span class="help-block">Please repeat your password.</span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-4">
                    <input class="btn btn-success" type="submit" value="Sign up" >
                </div>
            </div>

        </form>
    </div>

    <script type="text/javascript">
        // поля, обязательные для заполнения
        $('.alert').hide();
        var fields = new Array("username", "email", "first_name", "last_name");

        $("#registration-form").submit(function() {
            var error = 0;

            for (var i = 0; i < fields.length; i++) {
                var input = $("#" + fields[i]);
                var group = $("#" + fields[i] + "-group");
                if(!input.val()) {
                    group.attr('class', 'form-group has-error');
                    error = 1;
                } else {
                    group.attr('class', 'form-group');
                    error = 0;
                }
            }

            var email = $("#email").val();
            if (!isValidEmail(email)) {
                $("#email-group").attr('class', 'form-group has-error');
                error = 2;
            } else {
                $("#email-group").attr('class', 'form-group');
            }

            var birthdate = $("#birthdate").val();
            if (!isValidBirthdate(birthdate)) {
                $("#birthdate-group").attr('class', 'form-group has-error');
                error = 3;
            } else {
                $("#birthdate-group").attr('class', 'form-group');
            }

            var address = $("#address").val();
            if (!isValidAddress(address)) {
                $("#address-group").attr('class', 'form-group has-error');
                error = 4;
            } else {
                $("#address-group").attr('class', 'form-group');
            }

            var passwd = $("#password").val();
            if (!isValidPassword(passwd)) {
                $("#password-group").attr('class', 'form-group has-error');
                error = 5;
            } else {
                $("#password-group").attr('class', 'form-group');
            }

            var passwd1 = $("#password1").val();
            if (passwd != passwd1) {
                $("#password1-group").attr('class', 'form-group has-error');
                error = 6;
            } else {
                $("#password1-group").attr('class', 'form-group');
            }

            if (error == 0) {
                return true;
            } else {
                var error_msg = "";
                if (error == 1) {
                    error_msg = "Не все обязательные поля заполнены!";
                }
                if (error == 2) {
                    error_msg = "Введен некорректый email!";
                }
                if (error == 3) {
                    error_msg = "Введена некорректная дата рождения!";
                }
                if (error == 4) {
                    error_msg = "Введен некорректный адрес!";
                }
                if (error == 5) {
                    error_msg = "Введен некорректный пароль!"
                }
                if (error == 6) {
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