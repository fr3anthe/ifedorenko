<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>edit user</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/edit" method="post">
            <input type="hidden" name="id" value="${param.id}">
            name: <input type="text" name="name" value="<c:out value="${param.name}"/>">
            email: <input type="text" name="email" value="<c:out value="${param.email}"/>">
            <input type="submit" value="edit">
        </form>
    </body>
</html>
