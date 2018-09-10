/*
package ru.job4j.controller.servlet;

import ru.job4j.model.dao.DUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UsersController")
public class UsersController extends HttpServlet {
    private final DUser user = DUser.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        synchronized (session) {
            if (session.getAttribute("role").equals("admin")) {
                request.setAttribute("users", user.getAll());
                request.getRequestDispatcher("/WEB-INF/views/adminList.jsp").forward(request, response);
            } else {
                request.setAttribute("user", user.getById(1));
                request.getRequestDispatcher("/WEB-INF/views/userList.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("login"));
        user.delete(id);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
*/
