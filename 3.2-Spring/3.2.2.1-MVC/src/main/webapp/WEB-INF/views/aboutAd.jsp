<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <title>Ad</title>
        <style>
            .main{
                width: 50%;
                margin-left: auto;
                margin-right: auto;
                margin-top: 100px;
            }
            .wrapper{
                white-space: nowrap;
            }

            .slide{
                background: #ccc;
                height: 100px;
                display: inline-block;
                width: 100px;
            }
        </style>
    </head>
    <body style="background-color: darkseagreen;">
        <div class="main">
            <dl class = "dl-horizontal">
                <dt>Brand</dt>
                <dd>${ad.car.brand.name}</dd>
                <dt>Model</dt>
                <dd>${ad.car.model}</dd>
                <dt>Vin</dt>
                <dd>${ad.car.vin}</dd>
                <dt>Carbody</dt>
                <dd>${ad.car.carbody.name}</dd>
                <dt>Color</dt>
                <dd >${ad.car.color}</dd>
                <dt>Engine</dt>
                <dd>${ad.car.engine.name}</dd>
                <dt>Power</dt>
                <dd>${ad.car.power}</dd>
                <dt>Transmission</dt>
                <dd>${ad.car.transmission.name}</dd>
                <br>
                <dt>Contact to order</dt>
                <dd>${ad.user.email}</dd>
                <br><br>
                <c:if test="${ad.user.login == sessionScope.user.login}">
                <dt>Change status:</dt>
                <dd>
                    <form action="${pageContext.servletContext.contextPath}/ad/changeStatus.do" method="post">
                        <select name="status" >
                            <option value="${ad.status}" hidden>Choose status</option>
                            <option value="true">Продается</option>
                            <option value="false">Продано</option>
                        </select>
                        <input type="submit" value="Submit">
                       <input type="hidden" name="id" value="${ad.id}">
                    </form>
                </dd>
                </c:if>
            </dl>
            <br>
            <div class="wrapper">
                <div id="slider4" class="text-center">
                    <c:forEach items="${images}" var="imag">
                        <div class="slide">
                            <a href="http://localhost:8080/support/image.do?path=${imag}">
                                <img align="right" style="width: 100%; height: 100%" src="/support/image.do?path=<c:out value="${imag}"/>">
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
