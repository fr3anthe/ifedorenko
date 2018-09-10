package ru.job4j.model.entities;

/**
 * AbstractEntity
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class BaseEntity implements Entity {
    protected int id;
    protected String name;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
