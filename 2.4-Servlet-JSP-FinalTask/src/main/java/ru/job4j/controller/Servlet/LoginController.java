package ru.job4j.controller.servlet;

import ru.job4j.model.dao.DUser;
import ru.job4j.model.entities.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String login = request.getParameter("login");
       String password = request.getParameter("password");
       User user = DUser.getInstance().isCredential(login, password);
        System.out.println(user);
        if (user != null) {
            String role = user.getRole().getName();
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
