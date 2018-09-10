package ru.job4j.model.entities;

/**
 * Music.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class MusicStyle extends BaseEntity {

    /**
     * Constructor №1.
     * @param name music style's name
     */
    public MusicStyle(final String name) {
        this.name = name;
    }

    /**
     * Constructor №2.
     * @param id id from db
     * @param name music style's name
     */
    public MusicStyle(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
}
