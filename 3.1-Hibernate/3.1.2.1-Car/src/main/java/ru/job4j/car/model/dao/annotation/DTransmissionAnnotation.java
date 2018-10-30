package ru.job4j.car.model.dao.annotation;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.annotation.TransmissionAnnotation;


/**
 * class DTransmissionAnnotation.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DTransmissionAnnotation extends DAOAbstract<TransmissionAnnotation> {

    /**
     * Singleton instance
     */
    private static final DTransmissionAnnotation INSTANCE = new DTransmissionAnnotation();

    /**
     * Private constructor.
     */
    private DTransmissionAnnotation() {
        super();
        this.logger = LoggerFactory.getLogger(DTransmissionAnnotation.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DTransmissionAnnotation getInstance() {
        return INSTANCE;
    }
}
