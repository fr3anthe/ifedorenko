package ru.job4j.car.model.entities.annotation;

import ru.job4j.car.model.entities.Entity;

import javax.persistence.*;


@MappedSuperclass
public abstract class BaseEntityAnnotation implements Entity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column
    protected String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
