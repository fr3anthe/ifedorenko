package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.Engine;
import java.util.List;

/**
 * class DEngine.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
public class DEngine extends DAOAbstract<Engine> {
    private static final DEngine INSTANCE = new DEngine();

    /**
     * Private Constructor
     */
    private DEngine() {
        this.logger = LoggerFactory.getLogger(DEngine.class);
    }

    @Override
    public Engine getById(int id) {
        return this.tx(session -> session.get(Engine.class, id));
    }

    @Override
    public List<Engine> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Engine").getResultList());
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DEngine getInstance() {
        return INSTANCE;
    }
}
