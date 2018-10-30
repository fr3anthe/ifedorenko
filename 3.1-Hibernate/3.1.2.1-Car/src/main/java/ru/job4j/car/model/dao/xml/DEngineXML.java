package ru.job4j.car.model.dao.xml;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.xml.EngineXML;

/**
 * class DEngineXML.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DEngineXML extends DAOAbstract<EngineXML> {
    /**
     * Singleton instance
     */
    private static final DEngineXML INSTANCE = new DEngineXML();

    /**
     * Private constructor.
     */
    private DEngineXML() {
        this.logger = LoggerFactory.getLogger(DEngineXML.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DEngineXML getInstance() {
        return INSTANCE;
    }

}
