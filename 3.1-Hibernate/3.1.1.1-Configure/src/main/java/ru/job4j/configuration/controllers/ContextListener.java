package ru.job4j.configuration.controllers;

import ru.job4j.configuration.models.database.HibernateFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class COntextListener.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateFactory.getInstance().close();
    }
}
