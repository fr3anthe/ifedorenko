package ru.job4j.car.model.dao.xml;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.xml.TransmissionXML;


/**
 * class DTransmissionXML.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DTransmissionXML extends DAOAbstract<TransmissionXML> {

    /**
     * Singleton instance
     */
    private static final DTransmissionXML INSTANCE = new DTransmissionXML();

    /**
     * Private constructor.
     */
    private DTransmissionXML() {
        this.logger = LoggerFactory.getLogger(DTransmissionXML.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DTransmissionXML getInstance() {
        return INSTANCE;
    }
}
