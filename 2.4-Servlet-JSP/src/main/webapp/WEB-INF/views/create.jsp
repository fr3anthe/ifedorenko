<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>create user</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <script>
            function validate() {
                var result = true;
                var elem = document.getElementById('form').elements;
                var str = '';
                for(var i = 0; i < elem.length - 3; i++)
                {
                    if (elem[i].value == '') {
                        str += elem[i].title + '\n';
                    }
                }
                if (str != '') {
                    result = false;
                    alert(str);
                }
                return result;
            }
            function getCities() {
                var country = $('#country').val();
                if (country != "") {
                    $.ajax({
                        type: "GET",
                        url: "/city",
                        data: {country : country},
                        success: function (data) {
                            var result = "";
                            var cities = data;
                            for (var i = 0; i != cities.length; i++) {
                                result += "<option value=" + cities[i] + ">" + cities[i] + "</option>"
                            }
                            var table = document.getElementById("city");
                            table.innerHTML = result;
                        }
                    })
                } else {
                    var table = document.getElementById("city");
                    table.innerHTML = "<option value=''>Custom Select Menu</option>"
                }
            }
        </script>

    </head>
    <body style="background-color: darkseagreen;">
        <div class="container">
            <h2>Create form</h2>
            <form id="form" method="post" onsubmit="return validate()">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" title="Enter user name." placeholder="Enter name" name="name">
                </div>
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input type="text" class="form-control" id="login" title="Enter user login."placeholder="Enter login" name="login">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" title="Enter user email."placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" title="Enter user password."placeholder="password" name="password">
                </div>
                <div class="form-group">
                    <label for="role">Select role:</label>
                    <select class="form-control" id ="role" name="role">
                        <option value="user">user</option>;
                        <option value="admin">admin</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="country">Select country:</label>
                    <select class="form-control" id ="country" name="country" onchange="getCities()">
                        <option value="">Choose country</option>
                        <option value="Russia">Russia</option>;
                        <option value="USA">USA</option>
                        <option value="German">German</option>
                    </select>
                </div>
                <div class="form group">
                    <label for="city">Choose city</label>
                    <select class="form-control" id ="city" name="city">
                        <option value="">Custom Select Menu</option>
                    </select>
                </div>
                <br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>

