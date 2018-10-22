package ru.job4j.servlets.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SigninController")
public class SigninController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (ValidateService.getInstance().isCredential(login, password)) {
            String role = ValidateService.getInstance().findByLogin(login).getRole();
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            session.setAttribute("role", role);
            response.sendRedirect(String.format("%s/", request.getContextPath()));
        } else {
            request.setAttribute("error", "credentional invalid");
            doGet(request, response);
        }
    }
}
