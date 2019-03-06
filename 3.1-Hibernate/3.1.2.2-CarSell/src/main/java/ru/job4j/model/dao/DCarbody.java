package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.Carbody;
import java.util.List;

/**
 * class DCarbody.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
public class DCarbody extends DAOAbstract<Carbody> {
    private static final DCarbody INSTANCE = new DCarbody();

    /**
     * Private Constructor
     */
    private DCarbody() {
        this.logger = LoggerFactory.getLogger(DCarbody.class);
    }

    @Override
    public Carbody getById(int id) {
        return this.tx(session -> session.get(Carbody.class, id));
    }

    @Override
    public List<Carbody> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Carbody").getResultList());
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DCarbody getInstance() {
        return INSTANCE;
    }
}
