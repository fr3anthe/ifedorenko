<%@ page import="ru.job4j.servlets.http.ValidateService" %>
<%@ page import="ru.job4j.servlets.http.User" %><%--
  Created by IntelliJ IDEA.
  User: ifedorenko
  Date: 07.08.2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main page</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/create">
            <input type="submit" value="create user">
        </form>
        <br/>
        <table style="border: 1p solid black;" cellpadding="1" cellspacing="1" border="1">
            <tr>
                <th> name </th>
                <th> login</th>
                <th> email </th>
            </tr>
            <% for (User user : ValidateService.getInstance().findAll()) { %>
                <tr>
                    <td><%=user.getName()%></td>
                    <td><%=user.getLogin()%></td>
                    <td><%=user.getEmail()%></td>
                    <td>
                        <form action="<%=request.getContextPath()%>/edit">
                            <input type="submit" value="edit user">
                            <input type="hidden" name="id" value="<%=user.getId()%>">
                            <input type="hidden" name="name" value="<%=user.getName()%>">
                            <input type="hidden" name="email" value="<%=user.getEmail()%>">
                        </form>
                    </td>
                    <td>
                        <form action="<%=request.getContextPath()%>/list" method="post">
                            <input type="submit" value="delete user">
                            <input type="hidden" name="id" value="<%=user.getId()%>">
                        </form>
                    </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
