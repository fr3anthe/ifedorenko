package ru.job4j.model.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Class User.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Advertisement> ads;

    /**
     * Default constrcutor.
     */
    public User() {
    };

    /**
     * Constructor.
     * @param login name
     * @param password password
     * @param email email
     */
    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Advertisement> getAds() {
        return ads;
    }

    public void setAds(List<Advertisement> ads) {
        this.ads = ads;
    }
}
