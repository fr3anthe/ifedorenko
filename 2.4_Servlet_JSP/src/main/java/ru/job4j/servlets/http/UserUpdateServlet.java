package ru.job4j.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class UserUpdateServlet.
 *
 * @author ifedorenko
 * @since 06.08.2018
 */
@WebServlet(name = "UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        request.setAttribute("user", ValidateService.getInstance().findByLogin(login));
        request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        ValidateService.getInstance().update(login, name, email, role, password, country, city);
        response.sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
