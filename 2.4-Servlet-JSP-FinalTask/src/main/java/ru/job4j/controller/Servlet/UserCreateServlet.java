package ru.job4j.controller.servlet;

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
        request.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        ValidateService.getInstance().add(name, login, email, role, password, country, city);
        response.sendRedirect(String.format("%s/", request.getContextPath()));*/
    }
}
