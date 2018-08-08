<%--
  Created by IntelliJ IDEA.
  User: ifedorenko
  Date: 07.08.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>edit user</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/edit" method="post">
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
            name: <input type="text" name="name" value="<%=request.getParameter("name")%>">
            email: <input type="text" name="email" value="<%=request.getParameter("email")%>">
            <input type="submit" value="edit">
        </form>
    </body>
</html>
