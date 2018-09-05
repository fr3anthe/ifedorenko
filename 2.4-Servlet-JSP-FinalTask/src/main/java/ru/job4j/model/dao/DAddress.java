package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.Address;

/**
 * DAddress.
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DAddress extends AbstractDAO<Address> {

    private static final DAddress INSTANCE = new DAddress("addresses", LoggerFactory.getLogger(DAddress.class));

    /**
     * Constructor.
     * @param table table name
     * @param logger logger
     */
    private DAddress(String table, Logger logger) {
        super(table, logger);
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DAddress getInstance() {
        return INSTANCE;
    }
}
