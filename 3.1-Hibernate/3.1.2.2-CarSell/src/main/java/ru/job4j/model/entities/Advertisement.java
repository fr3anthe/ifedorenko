package ru.job4j.model.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Class Advertisement
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Entity
@Setter
@Getter
@Table(name = "ad")
public class Advertisement extends BaseEntity {
    @Column
    private String theme;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private boolean status;

    /**
     * Default constrcutor.
     */
    public Advertisement() {
    }

    /**
     * Constructor
     * @param theme theme
     * @param car car_id
     * @param user user_id
     * @param status relevant or not
     */
    public Advertisement(String theme, Car car, User user, boolean status) {
        this.theme = theme;
        this.car = car;
        this.user = user;
        this.status = status;
    }
}
