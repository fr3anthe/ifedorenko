package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.*;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;

/**
 * class DCar.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Component
@Scope("singleton")
public class DCar extends DAOAbstract<Car> {
    /**
     * Constructor
     * @param factory db factory
     */
    @Autowired
    public DCar(HibernateFactory factory) {
        super(factory);
        this.logger = LoggerFactory.getLogger(DCar.class);
    }

    @Override
    public Car getById(int id) {
        return this.tx(session -> session.get(Car.class, id));
    }

    @Override
    public List<Car> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Car").getResultList());
    }

    /**
     * Get car by vin.
     *
     * @param vin vin for get
     * @return car's list
     */
    public List<Car> getByVin(String vin) {
        return this.tx(session -> {
            Query query = session.createQuery("from Car where vin =: vin");
            query.setParameter("vin", vin);
            return (List<Car>) query.list();
        });
    }
}
