package ru.job4j.model.entities;

import java.util.List;

/**
 * User.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class User extends BaseEntity {
    private String login;
    private String password;
    private Role role;
    private Address address;
    private List<MusicType> musicTypes;

    /**
     * Constructor №1.
     * @param login login
     * @param password password
     * @param role role
     * @param address address
     */
    public User(String login, String password, String role, String address) {
        this.login = login;
        this.password = password;
        this.role = new Role(role);
        this.address = new Address(address);
    }

    /**
     * Constructor №2.
     * @param id id
     * @param login login
     * @param role role
     * @param address address
     */
    public User(int id, String login, Role role, Address address) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.address = address;
        this.musicTypes = musicTypes;
    }


    /**
     * Getter for login.
     * @return login
     */
    public String getLogin() {
        return login;
    }
    /**
     * Setter for login.
     * @param login login's value
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Getter for password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter for password.
     * @param password password's value
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Getter for role.
     * @return role
     */
    public Role getRole() {
        return role;
    }
    /**
     * Setter for role.
     * @param role role's value
     */
    public void setRole(String role) {
        this.role = new Role(role);
    }

    /**
     * Getter for address.
     * @return address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * Setter for address.
     * @param address address's value
     */
    public void setAddress(String address) {
        this.address = new Address(address);
    }

    /**
     * Getter for musicTypes.
     * @return musicTypes
     */
    public List<MusicType> getMusicTypes() {
        return musicTypes;
    }

    /**
     * Setter for musicTypes.
     * @param musicTypes musicTypes's value
     */
    public void setMusicTypes(List<MusicType> musicTypes) {
        this.musicTypes = musicTypes;
    }
}
