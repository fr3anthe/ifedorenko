package ru.job4j.model.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.Brand;
import ru.job4j.model.hibernate.HibernateFactory;
import java.util.List;

/**
 * class DBrand.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Component
@Scope("singleton")
public class DBrand extends  DAOAbstract<Brand> {

    /**
     * Constructor
     * @param factory db factory
     */
    @Autowired
    public DBrand(HibernateFactory factory) {
        super(factory);
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
}
