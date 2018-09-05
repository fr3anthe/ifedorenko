package ru.job4j.model.entities;

/**
 * Role.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class Role extends BaseEntity {

    /**
     * Constructor. Create object to add in DB.
     * @param name name
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Constructor. Create object from DB.
     * @param id id
     * @param name name
     */
    public Role(int id, String name) {
        super(id, name);
    }
}
