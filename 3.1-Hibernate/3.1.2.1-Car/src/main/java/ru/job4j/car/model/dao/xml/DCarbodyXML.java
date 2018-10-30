package ru.job4j.car.model.dao.xml;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.xml.CarbodyXML;

/**
 * class DCarbodyXML.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DCarbodyXML extends DAOAbstract<CarbodyXML> {
    /**
     * Singleton instance
     */
    private static final DCarbodyXML INSTANCE = new DCarbodyXML();

    /**
     * Private constructor.
     */
    private DCarbodyXML() {
        this.logger = LoggerFactory.getLogger(DCarbodyXML.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DCarbodyXML getInstance() {
        return INSTANCE;
    }

}
