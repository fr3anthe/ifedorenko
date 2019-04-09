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
    </head>
    <body style="background-color: darkseagreen">
    <div class="container-fluid">
        <form class="btn float-right" action="${pageContext.servletContext.contextPath}/exit">
            <input type="submit" class="btn btn-primary" value="exit">
        </form>
        <form class="btn float-left" action="${pageContext.servletContext.contextPath}/createAd">
            <input type="submit" class="btn btn-primary" value="create AD">
        </form>
        <br>
        <div class="container-fluid">
            <h3 align="center">Cars</h3>
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
                            <a class="text-light bg-dark" href="aboutAd?id=<c:out value="${id}"/>">${ad.theme}</a>
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