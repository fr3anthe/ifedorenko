package ru.job4j.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class UserCreateServlet.
 *
 * @author ifedorenko
 * @since 06.08.2018
 */
@WebServlet(name = "UserCreateServlet")
public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(String.format("%s/create.jsp", request.getContextPath())).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        ValidateService.getInstance().add(name, login, email);
        response.sendRedirect(String.format("%s/list.jsp", request.getContextPath()));
    }
}
