package ru.job4j.servlets.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class JsonCityController.
 *
 * @author ifedorenko
 * @since 28.08.2018
 */
public class JsonCityController extends HttpServlet {
    private ConcurrentHashMap<String, String[]> store = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String country = req.getParameter("country");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(mapper.writeValueAsString(store.get(country)));
        writer.flush();
    }

    @Override
    public void init() throws ServletException {
        String[] russia = {"Moscow", "SPB", "Saransk", "Tver", "Vladivostok", "Sochi"};
        String[] usa = {"NY", "LA", "SA", "SD", "Denver", "Washington"};
        String[] german = {"Berlin", "Hamburg", "Munich", "Styttgart", "Leipzig", "Dresden"};
        store.put("Russia", russia);
        store.put("USA", usa);
        store.put("German", german);
    }
}
