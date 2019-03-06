package ru.job4j.controllers.servlets;

import ru.job4j.model.dao.DUser;
import ru.job4j.model.entities.User;
import ru.job4j.service.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet RegistrationController.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (!ValidateService.getInstance().isUserExist(login)) {
            DUser.getInstance().add(new User(login, password, email));
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "user already exist");
            doGet(request, response);
        }
    }
}
