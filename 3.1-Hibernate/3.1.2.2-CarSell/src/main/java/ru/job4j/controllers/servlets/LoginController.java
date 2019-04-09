package ru.job4j.controllers.servlets;

import ru.job4j.model.entities.User;
import ru.job4j.service.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet LoginController.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final int FAIL_LOGIN = -1;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        int id = ValidateService.getInstance().isUserCredential(login, password);
        if (id != FAIL_LOGIN) {
            HttpSession session = request.getSession();
            session.setAttribute("user", new User(id, login));
            response.sendRedirect(String.format("%s/listAd", request.getContextPath()));
        } else {
            request.setAttribute("error", "credentional invalid");
            doGet(request, response);
        }
    }
}
