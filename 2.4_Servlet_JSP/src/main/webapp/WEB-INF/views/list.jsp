<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Main page</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/create">
            <input type="submit" value="create user">
        </form>
        <br/>
        <table style="border: 1p solid black;" cellpadding="1" cellspacing="1" border="1">
            <tr>
                <th> name </th>
                <th> login</th>
                <th> email </th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/edit">
                            <input type="submit" value="edit user">
                            <input type="hidden" name="id" value="${user.id}">
                            <input type="hidden" name="name" value="${user.name}">
                            <input type="hidden" name="email" value="${user.email}">
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/list" method="post">
                            <input type="submit" value="delete user">
                            <input type="hidden" name="id" value="${user.id}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>