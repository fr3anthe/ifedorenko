package ru.job4j.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface Creator.
 */
public interface Creator {
    /**
     * Method manage.
     * @return product's object
     */
    Product manage();
}
