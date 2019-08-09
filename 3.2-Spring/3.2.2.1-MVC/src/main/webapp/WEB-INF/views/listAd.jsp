<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Advertisement List</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script>
            function checkModelFilter() {
                if ($('#filter').val() == 'model') {
                    $('#model').show();
                } else {
                    $('#model').hide();
                }
            }

            function validateFilter() {
                var result = true;
                var temp = $('#filter');
                if (temp.val() == '') {
                    alert(temp.attr('title'));
                    result = false;
                } else if (temp.val() == 'model') {
                    temp = $('#model');
                    if (temp.val() == '') {
                        alert(temp.attr('title'));
                        result = false;
                    }
                }
                return result;
            }
        </script>
    </head>
    <body style="background-color: darkseagreen">
    <div class="container-fluid">
        <form class="btn float-right" action="${pageContext.servletContext.contextPath}/account/exit.do">
            <input type="submit" class="btn btn-primary" value="exit">
        </form>
        <form class="btn float-left" action="${pageContext.servletContext.contextPath}/ad/createAd.do">
            <input type="submit" class="btn btn-primary" value="create AD">
        </form>
        <br>
        <div class="container-fluid">
            <h3 align="center">Cars</h3>
            <div class="form-group">
                <form class="form-inline float-right" action="${pageContext.servletContext.contextPath}/support/filter.do" onsubmit="return validateFilter()">
                    <div align="right">
                        <select title="Choose filter" id ="filter" name="type" onchange="checkModelFilter()">
                            <option value="">Choose filter</option>
                            <option value="day">last day</option>;
                            <option value="photo">with photo</option>
                            <option value="model">model</option>
                        </select>
                    </div>
                    <div>
                        <input style="display: none" id="model" title="Enter car model!" name="value">
                    </div>
                    <input type="submit" value="Отфильтровать">
                </form>
            </div>
            <br>
             <table style="text-align: center" class="table table-hover table-bordered table-dark">
                <thead class="thead-gray">
                    <tr>
                        <th>theme</th>
                        <th class="w-25">author</th>
                        <th class="w-25">date</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                <c:forEach items="${ads}" var="ad">
                    <c:if test="${(ad.user.login == sessionScope.user.login) || (ad.status == 'true')}" >
                    <tr>
                        <td>
                            <c:set var="id" value="${ad.id}"/>
                            <a class="text-light bg-dark" href="aboutAd.do?id=<c:out value="${id}"/>">${ad.theme}</a>
                        </td>
                        <td>${ad.user.login}</td>
                        <td>${ad.date}</td>
                     </tr>
                     </c:if>
                </c:forEach>
                </tbody>
             </table>
        </div>
    </div>
    </body>
</html>