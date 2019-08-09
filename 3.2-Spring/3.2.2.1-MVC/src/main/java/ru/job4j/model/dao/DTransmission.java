package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.Transmission;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;

/**
 * class DTransmission.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Component
@Scope("singleton")
public class DTransmission extends DAOAbstract<Transmission> {
    /**
     * Constructor
     * @param factory db factory
     */
    public DTransmission(HibernateFactory factory) {
        super(factory);
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
}
