package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.Transmission;
import java.util.List;

/**
 * class DTransmission.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
public class DTransmission extends DAOAbstract<Transmission> {
    private static final DTransmission INSTANCE = new DTransmission();

    /**
     * Private Constructor
     */
    private DTransmission() {
        this.logger = LoggerFactory.getLogger(DTransmission.class);
    }

    @Override
    public Transmission getById(int id) {
        return this.tx(session -> session.get(Transmission.class, id));
    }

    @Override
    public List<Transmission> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Transmission").getResultList());
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DTransmission getInstance() {
        return INSTANCE;
    }
}
