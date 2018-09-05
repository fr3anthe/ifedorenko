package ru.job4j.model.entities;

/**
 * AbstractEntity
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class BaseEntity {
    protected int id;
    protected String name;

    /**
     * Constructor.
     */
    public BaseEntity() {
    }

    /**
     * Constrcutor.
     * @param id id
     * @param name name
     */
    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id id's value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name name's value
     */
    public void setName(String name) {
        this.name = name;
    }
}
