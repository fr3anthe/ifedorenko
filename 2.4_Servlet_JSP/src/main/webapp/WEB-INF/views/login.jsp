<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>LoginView</title>
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
        <form action="${pageContext.servletContext.contextPath}/signin" method="post">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" name="login" id="login" placeholder="Enter login">
            </div>
            <div class="form-group">
                <label for="password">Email address</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
            </div>
            <input type="submit" value="login">
        </form>
</body>
</html>