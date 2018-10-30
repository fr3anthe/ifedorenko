package ru.job4j.car.model.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Singleton HibernateFactory.
 *
 * @author ifedorenko
 * @since 12.10.2018
 */
public class HibernateFactory {
    /**
     * @param INSTANCE instance
     */
    private static final HibernateFactory INSTANCE = new HibernateFactory();
    private final SessionFactory factory;

    /**
     * Private constructor.
     */
    private HibernateFactory() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Method GetFactory.
     * @return session's factory
     */
    public SessionFactory getFactory() {
        return factory;
    }

    /**
     * Methog close.
     */
    public void close() {
        if (factory != null) {
            factory.close();
        }
    }

    /**
     * Method getInstance.
     * @return instance
     */
    public static HibernateFactory getInstance() {
        return INSTANCE;
    }
}
