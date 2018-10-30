package ru.job4j.car.model.dao.xml;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.xml.CarXML;

/**
 * class DCarXML.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DCarXML extends DAOAbstract<CarXML> {
    /**
     * Singleton instance
     */
    private static final DCarXML INSTANCE = new DCarXML();

    /**
     * Private constructor.
     */
    private DCarXML() {
        this.logger = LoggerFactory.getLogger(DCarXML.class);
    }

    /**
     * Method getInstance.
     *
     * @return INSTANCE
     */
    public static DCarXML getInstance() {
        return INSTANCE;
    }
}
