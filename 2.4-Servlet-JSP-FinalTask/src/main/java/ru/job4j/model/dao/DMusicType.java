package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.MusicType;

/**
 * DMusicType
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DMusicType extends AbstractDAO<MusicType> {

    private static final DMusicType INSTANCE = new DMusicType("music_types", LoggerFactory.getLogger(DMusicType.class));

    /**
     * Constructor.
     * @param table table name
     * @param logger logger
     */
    private DMusicType(String table, Logger logger) {
        super(table, logger);
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DMusicType getInstance() {
        return INSTANCE;
    }
}
