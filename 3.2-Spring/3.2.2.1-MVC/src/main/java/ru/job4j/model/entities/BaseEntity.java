package ru.job4j.model.entities;

import javax.persistence.*;

/**
 * Abstract class BaseEntity.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@MappedSuperclass
public abstract class BaseEntity implements Entity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
