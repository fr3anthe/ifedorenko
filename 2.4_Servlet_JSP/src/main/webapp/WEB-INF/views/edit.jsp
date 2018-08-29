<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>edit user</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script>
            function getCities() {
                $.ajax({
                    type: "GET",
                    url: "/city",
                    data: {country : $('#country').val()},
                    success : function (data) {
                        var result = "";
                        var cities = data;
                        for (var i = 0; i != cities.length; i++) {
                            result += "<option value=" + cities[i] + ">" + cities[i] + "</option>"
                        }
                        var table = document.getElementById("city");
                        table.innerHTML = result;
                    }
                })
            }
        </script>
    </head>
    <body style="background-color: darkseagreen;">
        <div class="container">
            <h2>Edit form</h2>
            <form method="post">
                <input type="hidden" name="login" value="${user.login}">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" value="<c:out value="${user.name}"/>" placeholder="Enter name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" value="<c:out value="${user.email}"/>" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" selected value="${user.password}" placeholder="password" name="password">
                </div>
                <c:if test="${sessionScope.role == 'admin'}">
                <div class="form-group">
                    <label for="role">Select role:</label>
                    <select class="form-control" id ="role" name="role">
                        <option selected value="${user.role}">Choose role</option>
                        <option value="user">user</option>;
                        <option value="admin">admin</option>
                    </select>
                </div>
                </c:if>
                <div class="form-group">
                    <label for="country">Select country:</label>
                    <select class="form-control" id ="country" name="country" onchange="getCities()">
                        <option selected value="${user.country}">Choose country</option>
                        <option value="Russia">Russia</option>;
                        <option value="USA">USA</option>
                        <option value="German">German</option>
                    </select>
                </div>
                <div class="form group">
                    <label for="city">Select city</label>
                    <select class="form-control" id ="city" name="city">
                        <option selected value="${user.city}">Choose city</option>
                    </select>
                </div>
                <br>
                <input type="submit" value="edit">
            </form>
        </div>
    </body>
</html>
