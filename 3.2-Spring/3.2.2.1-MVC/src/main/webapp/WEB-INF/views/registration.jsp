<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            function validateRegistration() {
                var result = true;
                var view = '';
                if ($('#login').val() == '') {
                    result = false;
                    view += ($("#login").attr('title')) + '\n';
                }
                if ($('#passwordF').val() == '') {
                    result = false;
                    view += ($("#passwordF").attr('title')) + '\n';
                }
                if ($('#passwordS').val() == '') {
                    result = false;
                    view += ($("#passwordS").attr('title')) + '\n';
                }
                if ($('#email').val() == '') {
                    result = false;
                    view += ($("#email").attr('title')) + '\n';
                }
                if (!result) {
                    alert(view)
                } else if (!($('#passwordF').val() == $('#passwordS').val())) {
                    view = 'Password does not match';
                    result = false;
                    alert(view)
                }
                return result;
            }
        </script>
        <title>Registration</title>
        <style>
            * {
                text-align: center;
            }
            form {
                margin-left: 40%;
                margin-right: 40%;
                text-align: center;
            }
            .error {
                background-color: red;
                text-align: center;
                margin-top: 100px;
                margin-left: 40%;
                margin-right: 40%;
            }
        </style>
    </head>
    <body style="background-color: darkseagreen;" id="LoginForm">
        <c:if test="${error != ' '}">
            <div class="error">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <form action="${pageContext.servletContext.contextPath}/account/registration.do" method="post" onsubmit="return validateRegistration()">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" id="login" title="Enter login" placeholder="Enter login">
            </div>
            <div class="form-group">
                <label for="passwordF">Password</label>
                <input type="password" class="form-control" name="password" id="passwordF" title="Enter password" placeholder="Enter password">
            </div>
            <div class="form-group">
                <label for="passwordS">Password</label>
                <input type="password" class="form-control" id="passwordS" title="Confirm password" placeholder="Confirm password">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" name="email" id="email" title="Enter email" placeholder="Enter email">
            </div>
            <input type="submit" class="btn btn-primary" value="registration">
        </form>
        <br>
        <form action="${pageContext.servletContext.contextPath}/account/login.do">
            <input type="submit" class="btn btn-primary" value="login">
        </form>
    </body>
</html>