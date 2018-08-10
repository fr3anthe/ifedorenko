package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (UserStorage.getInstance().isCredential(login, password)) {
            HttpSession session = request.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
            }
            response.sendRedirect(String.format("%s/", request.getContextPath()));
        } else {
            request.setAttribute("error", "credentional invalid");
            doGet(request, response);
        }
    }
}
