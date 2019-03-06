package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.*;

import java.util.List;

/**
 * class DCar.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
public class DCar extends DAOAbstract<Car> {
    private static final DCar INSTANCE = new DCar();

    /**
     * Private Constructor
     */
    private DCar() {
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


    /**
     * Method getInstance.
     *
     * @return INSTANCE
     */
    public static DCar getInstance() {
        return INSTANCE;
    }
}
