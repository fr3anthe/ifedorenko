package ru.job4j.servlets.http;

import java.time.LocalDate;

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
     * user's role
     */
    private String role;
    /**
     * user's password
     */
    private String password;
    /**
     * user's country
     */
    private String country;
    /**
     * user's city
     */
    private String city;

    /**
     * Constructor for User. Used for add in the db.
     * @param name user's name
     * @param login user's login
     * @param email user's email
     * @param role user's role
     * @param password user's password
     * @param country user's country
     * @param city user's city
     */
    public User(String name, String login, String email, String role, String password, String country, String city) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
        this.password = password;
        this.country = country;
        this.city = city;
    }

    /**
     * Setter for name.
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for email.
     * @param email new email.
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * Getter for role.
     * @return users's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for role.
     * @param role user's role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter for password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for country.
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for country.
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for city.
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city.
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
