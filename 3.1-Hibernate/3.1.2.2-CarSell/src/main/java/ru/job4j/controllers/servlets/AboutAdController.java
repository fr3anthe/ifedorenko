package ru.job4j.controllers.servlets;

import ru.job4j.model.dao.DAdvertisement;
import ru.job4j.model.entities.Advertisement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/aboutAd")
public class AboutAdController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Advertisement ad  = DAdvertisement.getInstance().getById(Integer.valueOf(request.getParameter("id")));
        if (ad.isImage()) {
            String path = getServletContext().getInitParameter("imageLocation") + File.separator + ad.getCar().getVin() + File.separator;
            List<String> images = new LinkedList<>();
            for (File file : new File(path).listFiles()) {
                images.add(file.toString().replace("\\", "/"));
            }
            request.setAttribute("images", images);
        }
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/views/aboutAd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        Advertisement advertisement = DAdvertisement.getInstance().getById(Integer.valueOf(id));
        advertisement.setStatus(Boolean.valueOf(status));
        DAdvertisement.getInstance().update(advertisement);
        response.sendRedirect(String.format("%s/listAd", request.getContextPath()));
    }
}
