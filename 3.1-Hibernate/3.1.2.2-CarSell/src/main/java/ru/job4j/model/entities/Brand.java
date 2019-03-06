package ru.job4j.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Brand
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
