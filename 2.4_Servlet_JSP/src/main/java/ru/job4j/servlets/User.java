package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: comment
 *
 * @author ifedorenko
 * @since 07.08.2018
 */
public class User {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    private String login;
    private String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
