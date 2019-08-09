package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.Carbody;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;

/**
 * class DCarbody.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Component
@Scope("singleton")
public class DCarbody extends DAOAbstract<Carbody> {
    /**
     * Constructor
     * @param factory db factory
     */
    @Autowired
    public DCarbody(HibernateFactory factory) {
        super(factory);
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
}
