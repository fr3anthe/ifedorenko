package ru.job4j.controllers.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet ImageLoadController.
 *
 * @author ifedorenko
 * @since 06.03.2019
 */
@WebServlet("/image/*")
public class ImageLoadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = req.getParameter("path");
        BufferedImage image = ImageIO.read(new FileInputStream(new File(imagePath)));
        ImageIO.write(image, "jpeg", resp.getOutputStream());
    }
}
