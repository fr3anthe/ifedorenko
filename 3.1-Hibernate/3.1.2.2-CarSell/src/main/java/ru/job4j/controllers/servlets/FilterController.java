package ru.job4j.controllers.servlets;

import ru.job4j.model.dao.DAdvertisement;
import ru.job4j.model.entities.Advertisement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@WebServlet("/filter")
public class FilterController extends HttpServlet {
    private final Map<String, Function<ServletRequest, List<Advertisement>>> map = new HashMap();
    private static final String PHOTO = "photo";
    private static final String DAY = "day";
    private static final String MODEL = "model";

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.map.put(PHOTO, request -> DAdvertisement.getInstance().getAllWithPhoto());
        this.map.put(DAY, request -> DAdvertisement.getInstance().getByLastDay());
        this.map.put(MODEL, request -> DAdvertisement.getInstance().getAllByModel(request.getParameter("model")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter = request.getParameter("filter");
        request.setAttribute("ads", this.map.get(filter).apply(request));
        request.getRequestDispatcher("/WEB-INF/views/listAd.jsp").forward(request, response);
    }
}
