package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.Engine;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;

/**
 * class DEngine.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Component
@Scope("singleton")
public class DEngine extends DAOAbstract<Engine> {
    /**
     * Constructor
     * @param factory db factory
     */
    @Autowired
    public DEngine(HibernateFactory factory) {
        super(factory);
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
}
