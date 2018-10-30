package ru.job4j.configuration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.configuration.models.entities.Item;
import ru.job4j.configuration.services.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AjaxServlet.class);
    private ValidateService service = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        System.out.println(mapper.writeValueAsString(service.getAll()));
        writer.append(mapper.writeValueAsString(service.getAll()));
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        sb.append(reader.readLine());
        Item item = mapper.readValue(sb.toString(), Item.class);
        service.add(item);
    }
}
