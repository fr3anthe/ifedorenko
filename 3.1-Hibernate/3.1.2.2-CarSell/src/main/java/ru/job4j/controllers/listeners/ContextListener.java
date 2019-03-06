package ru.job4j.controllers.listeners;

import ru.job4j.model.hibernate.HibernateFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Class ContextListener.
 * Uses it for closing hibernate factory.
 *
 * @author ifedorenko
 * @since 19.11.2018
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }
    /**
     * Method contextDestroyed.
     * @param sce event
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateFactory.getInstance().close();
    }
}
