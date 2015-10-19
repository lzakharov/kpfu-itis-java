<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <#include "anon_nav.ftl">

    <div class="container">
        <form class="form-horizontal" action='/registration' method="POST">
            <fieldset>
                <div id="legend">
                    <legend class="">Register</legend>
                </div>

                <#if error_msg??>
                    <div class="alert alert-danger">${error_msg}</div>
                </#if>

                <div class="control-group">
                    <label class="control-label"  for="username">Username</label>
                    <div class="controls">
                        <input type="text" id="username" name="username" <#if username??>value="${username}"</#if> class="input-xlarge">
                        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="email">E-mail</label>
                    <div class="controls">
                        <input type="text" id="email" name="email" <#if email??>value="${email}</#if>" class="input-xlarge">
                        <p class="help-block">Please provide your E-mail</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"  for="first_name">First Name</label>
                    <div class="controls">
                        <input type="text" id="first_name" name="first_name" <#if first_name??>value="${first_name}</#if>"  class="input-xlarge">
                        <p class="help-block">Please provide your first name</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"  for="last_name">Last Name</label>
                    <div class="controls">
                        <input type="text" id="last_name" name="last_name" <#if last_name??>value="${last_name}</#if>"  class="input-xlarge">
                        <p class="help-block">Please provide your last name</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"  for="birthdate">Birthdate</label>
                    <div class="controls">
                        <input type="date" id="birthdate" name="birthdate" <#if birthdate??>value="${birthdate}</#if>" >
                        <p class="help-block">Please provide your birthdate</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="address">Address</label>
                    <div class="controls">
                        <input type="text" id="address" name="address" <#if address??>value="${address}</#if>" class="input-xlarge">
                        <p class="help-block">Please provide your address</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                        <p class="help-block">Password should be at least 4 characters</p>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"  for="password_confirm">Password (Confirm)</label>
                    <div class="controls">
                        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
                        <p class="help-block">Please confirm password</p>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button class="btn btn-success">Register</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>