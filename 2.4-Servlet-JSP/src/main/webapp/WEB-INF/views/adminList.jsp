<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <title>All users</title>
        <style>
           * {
               text-align: center;
           }
        </style>
    </head>

    <body style="background-color: darkseagreen;">
        <div class="container" >
            <h2 style="text-align: center">Users table</h2>
                <form class="btn float-left" action="${pageContext.servletContext.contextPath}/create">
                    <input type="submit" class="btn btn-primary" value="create user">
                </form>
                <form class="btn float-right" action="${pageContext.servletContext.contextPath}/exit" method="post">
                    <input type="submit" class="btn btn-primary" value="exit">
                </form>
            <table class="table table-bordered table-dark">
                <thead>
                <tr>
                    <th>name</th>
                    <th>login</th>
                    <th>email</th>
                    <th>role</th>
                    <th>country</th>
                    <th>city</th>
                    <th colspan="3">action</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.login}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.role}"/></td>
                            <td><c:out value="${user.country}"/></td>
                            <td><c:out value="${user.city}"/></td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/edit">
                                    <input type="submit" class="btn btn-primary"  value="edit user">
                                    <input type="hidden" name="login" value="${user.login}">
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/list" method="post">
                                    <input type="submit" class="btn btn-warning" value="delete user">
                                    <input type="hidden" name="login" value="${user.login}">
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/upload" method="post" enctype="multipart/form-data">
                                    <input type="file" name="file"/>
                                    <input type="submit" class="btn btn-warning" value="upload">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>