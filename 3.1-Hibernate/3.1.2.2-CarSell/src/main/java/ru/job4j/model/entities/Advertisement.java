package ru.job4j.model.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

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
    @Column
    private Timestamp date;
    @Column
    private boolean image;

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
     * @param date date
     * @param image path to images
     * @param status relevant or not
     */
    public Advertisement(String theme, Car car, User user, Timestamp date, boolean image, boolean status) {
        this.theme = theme;
        this.car = car;
        this.user = user;
        this.date = date;
        this.image = image;
        this.status = status;
    }
}
