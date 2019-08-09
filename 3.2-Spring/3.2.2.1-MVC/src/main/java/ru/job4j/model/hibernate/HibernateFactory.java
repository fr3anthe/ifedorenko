package ru.job4j.model.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * HibernateFactory.
 *
 * @author ifedorenko
 * @since 13.11.2018
 */
@Component
@Scope("singleton")
public class HibernateFactory {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateFactory.class);
    private final SessionFactory factory;

    /**
     * Constructor.
     */
    public HibernateFactory() {
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
    @PreDestroy
    public void close() {
        if (factory != null) {
            factory.close();
            LOGGER.info("factory is closed");
        }
    }
}
