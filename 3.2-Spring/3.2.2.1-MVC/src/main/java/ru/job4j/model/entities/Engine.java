package ru.job4j.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Engine.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Entity
@Table(name = "engine")
public class Engine extends BaseEntity {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
