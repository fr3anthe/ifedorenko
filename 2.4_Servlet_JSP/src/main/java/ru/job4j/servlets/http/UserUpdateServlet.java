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
        Pages.printEdit(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        ValidateService.getInstance().update(id, name, email);
        doGet(request, response);
    }
}
