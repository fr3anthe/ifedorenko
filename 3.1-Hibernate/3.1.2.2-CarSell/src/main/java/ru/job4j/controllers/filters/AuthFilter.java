package ru.job4j.controllers.filters;

import ru.job4j.model.entities.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class AuthFilter.
 *
 * @author ifedorenko
 * @since 27.02.2018
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().contains("/login")) {
            chain.doFilter(request, response);
        } else if (req.getRequestURI().contains("/registration")) {
            chain.doFilter(request, response);
        } else {
            if (((User) ((HttpServletRequest) request).getSession().getAttribute("user")).getLogin() == null) {
                ((HttpServletResponse) response).sendRedirect(String.format("%s/login", req.getContextPath()));
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
