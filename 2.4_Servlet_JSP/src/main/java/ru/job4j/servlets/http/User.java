package ru.job4j.servlets.http;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Class User.
 * @author ifedorenko
 * @since 27.07.2018
 */
public class User {
    /**
     * user's id
     */
    private int id;
    /**
     * user's name
     */
    private String name;
    /**
     * user's login
     */
    private String login;
    /**
     * user's email
     */
    private String email;
    /**
     * user's create date
     */
    private LocalDate createDate;

    /**
     * Constructor for User.
     * @param name user's name
     * @param login user's login
     * @param email user's email
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    /**
     * Constructor for User.
     * @param id user's id from db
     * @param name user's name
     * @param login user's login
     * @param email user's email
     * @param createDate user's create date from db
     */
    public User(int id, String name, String login, String email, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Getter for id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for name.
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for email.
     * @param email new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for login.
     * @return login
     */
    public String getLogin() {
        return login;
    }
}
