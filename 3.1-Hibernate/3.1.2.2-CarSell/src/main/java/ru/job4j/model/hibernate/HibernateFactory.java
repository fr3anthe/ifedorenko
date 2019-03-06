package ru.job4j.model.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HibernateFactory.
 *
 * @author ifedorenko
 * @since 13.11.2018
 */
public class HibernateFactory {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateFactory.class);
    /**
     * INSTANCE.
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
     * Get factory.
     * @return SessionFactory.
     */
    public SessionFactory getFactory() {
        return factory;
    }

    /**
     * Close.
     * Close SessionFactory.
     */
    public void close() {
        if (factory != null) {
            factory.close();
            LOGGER.info("factory is closed");
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
