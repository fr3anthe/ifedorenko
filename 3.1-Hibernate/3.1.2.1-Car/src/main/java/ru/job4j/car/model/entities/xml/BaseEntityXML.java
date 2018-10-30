package ru.job4j.car.model.entities.xml;

import ru.job4j.car.model.entities.Entity;

/**
 * Class BaseEntityXML.
 */
public abstract class BaseEntityXML implements Entity {
    protected int id;
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
