package ru.job4j.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Transmission.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Entity
@Table(name = "transmission")
public class Transmission extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
