package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.core.DB;
import ru.job4j.model.entities.Brand;

import java.util.List;

/**
 * class DBrand.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
public class DBrand extends  DAOAbstract<Brand> {
    private static final DBrand INSTANCE = new DBrand();

    /**
     * Private Constructor
     */
    private DBrand() {
        this.logger = LoggerFactory.getLogger(DBrand.class);
    }

    @Override
    public Brand getById(int id) {
        return this.tx(session -> session.get(Brand.class, id));
    }

    @Override
    public List<Brand> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Brand").getResultList());
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DBrand getInstance() {
        return INSTANCE;
    }
}
