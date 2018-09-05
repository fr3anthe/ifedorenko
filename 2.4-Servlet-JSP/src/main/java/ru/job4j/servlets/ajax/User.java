package ru.job4j.servlets.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class user for ajax.
 *
 * @author ifedorenko
 * @since 24.08.2018
 */

public class User {
    private String firstName;
    private String lastName;
    private String sex;
    private String description;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param firstName firstname
     * @param lastName lasrname
     * @param sex sex
     * @param description description
     */
    public User(String firstName, String lastName, String sex, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.description = description;
    }

    /**
     * Getter for firstname.
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Getter for lastname.
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Getter for sex.
     * @return sex
     */
    public String getSex() {
        return sex;
    }
    /**
     * Getter getter for description.
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
