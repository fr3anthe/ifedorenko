package ru.job4j.controllers.servlets;

import ru.job4j.model.dao.DAdvertisement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet ListAdController.
 *
 * @author ifedorenko
 * @since 27.02.2019
 */
@WebServlet("/listAd")
public class ListAdController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DAdvertisement.getInstance().getAll());
        request.getRequestDispatcher("/WEB-INF/views/listAd.jsp").forward(request, response);
    }
}
