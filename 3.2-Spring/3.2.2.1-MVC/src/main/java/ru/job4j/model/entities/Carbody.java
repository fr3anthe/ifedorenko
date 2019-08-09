package ru.job4j.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class CarBody.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Entity
@Table(name = "carbody")
public class Carbody extends BaseEntity {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
