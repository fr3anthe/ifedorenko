package ru.job4j.model.entities;

/**
 * Address.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class Address extends BaseEntity {

    /**
     * Constructor. Create object to add in DB.
     * @param name address
     */
    public Address(String name) {
        this.name = name;
    }

    /**
     * Constructor. Create object from DB.
     * @param id id
     * @param name address
     */
    public Address(int id, String name) {
        super(id, name);
    }

}
