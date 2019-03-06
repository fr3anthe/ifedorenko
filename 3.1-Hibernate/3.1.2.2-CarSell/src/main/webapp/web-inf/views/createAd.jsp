<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>create ad</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var result = true;
            var view = '';
            view = getTitle('theme', view);
            view = getTitle('brand', view);
            view = getTitle('model', view);
            view = getTitle('vin', view);
            view = getTitle('carbody', view);
            view = getTitle('color', view);
            view = getTitle('engine', view);
            view = getTitle('power', view);
            view = getTitle('transmission', view);

            if (view != '') {
                result = false;
                alert(view);
            } else if ($('#vin').val().length != 17) {
                view = 'Vin must contain 17 characters';
                result = false;
                alert(view)
            }
            return result;
        }
        function getTitle(id, view) {
            if ($('#' + id).val() == '') {
                view += $('#' + id).attr('title') + '\n';
            }
            return view;
        }

    </script>
    <style>
        .error {
            background-color: red;
            text-align: center;
            margin-top: 10px;
            margin-left: 40%;
            margin-right: 40%;
        }
    </style>

</head>
<body style="background-color: darkseagreen;">
<c:if test="${error != ' '}">
    <div class="error">
        <c:out value="${error}"/>
    </div>
</c:if>
<div class="container">
    <h2 align="center">Create form</h2>
    <form id="form" action="${pageContext.servletContext.contextPath}/createAd" method="post" enctype="multipart/form-data" onsubmit="return validate()">
        <div class="form-group">
            <label for="theme">Theme:</label>
            <textarea class="form-control" id="theme" name="theme" title="Enter theme" rows="3"></textarea>
        </div>
        <h3 align="center">Car</h3>
        <div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="brand">Select brand:</label>
                <select class="col-xs-2" id ="brand" title="Select brand." name="brand">
                    <option value="" hidden>Choose brand</option>
                    <c:forEach items="${brands}" var="brand">
                        <option value="${brand.id}">${brand.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="brand">Enter model:</label>
                <input type="text" class="col-xs-2" id="model" title="Enter car's model." name="model">
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="vin">Enter vin:</label>
                <input type="text" class="col-xs-2" id="vin" title="Enter car's vin." name="vin">
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="carbody">Select carbody:</label>
                <select class="col-xs-2" id ="carbody" title="Select carbody." name="carbody">
                    <option value="" hidden>Select carbody</option>
                    <c:forEach items="${carbodies}" var="carbody">
                        <option value="${carbody.id}">${carbody.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="color">Select color:</label>
                <input type="color" class="col-sm-2" id="color" value="#ffffff" name="color">
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="engine">Select engine:</label>
                <select class="col-xs-2" id ="engine" title="Select engine." name="engine" >
                    <option value="" hidden>Select engine</option>
                    <c:forEach items="${engines}" var="engine">
                        <option value="${engine.id}">${engine.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="power">Enter power:</label>
                <input type="text" class="col-xs-2" id="power" title="Enter engine's power." name="power"> л.с.
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="transmission">Select transmission:</label>
                <select class="col-xs-2" id ="transmission" title="Select transmission." name="transmission">
                    <option value="" hidden>Select transmission</option>
                    <c:forEach items="${transmissions}" var="transmission">
                        <option value="${transmission.id}">${transmission.name}</option>
                    </c:forEach>
                </select>
            </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="photo">Select photo</label>
                <input class="col-xs-2" type="file" name="file" multiple accept="image/*" id="photo">
            </div>
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

