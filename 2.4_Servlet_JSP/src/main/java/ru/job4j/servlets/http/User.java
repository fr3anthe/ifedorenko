package ru.job4j.servlets.http;

import java.time.LocalDateTime;

/**
 * Class User.
 * @author ifedorenko
 * @since 27.07.2018
 */
public class User {
    /**
     * user's id
     */
    private final int id;
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
    private final LocalDateTime createDate;

    /**
     * Constructor for User.
     * @param id user's id
     * @param name user's name
     * @param login user's login
     * @param email user's email
     */
    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = LocalDateTime.now();
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

    @Override
    public String toString() {
        return "id=" + id
                + ", name=" + name
                + ", login=" + login
                + ", email=" + email
                + ", create=" + createDate;
    }
}
