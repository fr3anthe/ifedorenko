package ru.job4j.model.entities;

/**
 * MusciType.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class MusicType extends BaseEntity {

    /**
     * Constructor. Create object to add in DB.
     * @param name name
     */
    public MusicType(String name) {
        this.name = name;
    }

    /**
     * Constructor. Create object from DB.
     * @param id id's value
     * @param name name's value
     */
    public MusicType(int id, String name) {
        super(id, name);
    }
}
