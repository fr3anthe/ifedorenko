package ru.job4j.controllers.servlets;

import ru.job4j.model.dao.*;
import ru.job4j.model.entities.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet CreateAdController.
 *
 * @author ifedorenko
 * @since 27.02.2019
 */
@WebServlet("/createAd")
@MultipartConfig
public class CreateAdController extends HttpServlet {
    private static final boolean STATUS = true;
    private static final String NO_PHOTO = "no photo";
    private static final String IMAGE = "image";
    private static final String FILE = "file";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("brands", DBrand.getInstance().getAll());
        request.setAttribute("carbodies", DCarbody.getInstance().getAll());
        request.setAttribute("engines", DEngine.getInstance().getAll());
        request.setAttribute("transmissions", DTransmission.getInstance().getAll());
        request.getRequestDispatcher("/WEB-INF/views/createAd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vin = request.getParameter("vin");
        if (DCar.getInstance().getByVin(vin).size() > 0) {
            request.setAttribute("error", "the car is already on sale");
            doGet(request, response);
        } else {
            String theme = request.getParameter("theme");
            Car car = this.createCar(request, vin);
            User user = this.getUser(request);
            boolean path = this.saveImage(request, vin);
            DAdvertisement.getInstance().add(new Advertisement(theme, car, user, new Timestamp(System.currentTimeMillis()), path, STATUS));
            response.sendRedirect(String.format("%s/listAd", request.getContextPath()));
        }
    }

    /**
     * Create car for ad.
     * @param req request
     * @param vin vin
     * @return car
     */
    private Car createCar(HttpServletRequest req, String vin) {
        Car car = new Car();
        car.setBrand(DBrand.getInstance().getById(Integer.valueOf(req.getParameter("brand"))));
        car.setModel(req.getParameter("model"));
        car.setVin(vin);
        car.setCarbody(DCarbody.getInstance().getById(Integer.valueOf(req.getParameter("carbody"))));
        car.setColor(req.getParameter("color"));
        car.setEngine(DEngine.getInstance().getById(Integer.valueOf(req.getParameter("engine"))));
        car.setPower(req.getParameter("power"));
        car.setTransmission(DTransmission.getInstance().getById(Integer.valueOf(req.getParameter("transmission"))));
        DCar.getInstance().add(car);
        return car;
    }

    /**
     * Get user from bd.
     * @param req request
     * @return user
     */
    private User getUser(HttpServletRequest req) {
        int id = ((User) req.getSession().getAttribute("user")).getId();
        return DUser.getInstance().getById(id);
    }

    /**
     * Get path to photo.
     * @param req request
     * @param vin vin
     * @return path
     * @throws IOException exception
     * @throws ServletException exception
     */
    private boolean saveImage(HttpServletRequest req, String vin) throws IOException, ServletException {
        boolean result = false;
        List<Part> fileParts = req.getParts().stream().filter(part -> FILE.equals(part.getName())).collect(Collectors.toList());
        if (fileParts.size() > 0 && fileParts.get(0).getContentType().contains(IMAGE)) {
            String path = this.checkPaths(vin);
            for (Part filePart : fileParts) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                filePart.write(path + File.separator + fileName);
            }
            result = true;
        }
        return result;
    }

    /**
     * Check paths.
     * @param vin vin for folder
     * @return path
     * @throws IOException exception
     */
    private String checkPaths(String vin) throws IOException {
        String folder = getServletContext().getInitParameter("imageLocation");
        Path temp = Paths.get(folder + File.separator + vin);
        if (!Files.exists(temp)) {
            Files.createDirectory(temp);
        }
        return temp.toString();
    }
}
