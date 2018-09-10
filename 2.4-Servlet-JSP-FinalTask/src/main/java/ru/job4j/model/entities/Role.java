package ru.job4j.model.entities;

/**
 * Role.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class Role extends BaseEntity {

    /**
     * Constructor №1.
     * @param name role's name
     */
    public Role(final String name) {
        this.name = name;
    }

    /**
     * Constructor №2.
     * @param id id from db
     * @param name role's name
     */
    public Role(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
}
