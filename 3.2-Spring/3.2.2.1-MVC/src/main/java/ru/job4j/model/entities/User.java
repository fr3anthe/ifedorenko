package ru.job4j.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@EqualsAndHashCode(of = {"login", "password"})
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

    /**
     * Constructor.
     * @param id id
     * @param login login
     */
    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }
}
