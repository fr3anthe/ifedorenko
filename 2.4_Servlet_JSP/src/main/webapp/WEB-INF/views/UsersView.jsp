<%@ page import="ru.job4j.servlets.UserStorage" %>
<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/" method="post">
    Login : <input type="text" name="login"><br/>
    Email : <input type="text" name="email"><br/>
    <input type="submit">
</form>
<br/>

<table style="border: 1p solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>login</th>
        <th>email</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.login }"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
