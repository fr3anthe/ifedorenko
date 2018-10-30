package ru.job4j.car.model.dao.annotation;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.annotation.CarbodyAnnotation;

/**
 * class DCarbodyAnnotation.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DCarbodyAnnotation extends DAOAbstract<CarbodyAnnotation> {
    /**
     * Singleton instance
     */
    private static final DCarbodyAnnotation INSTANCE = new DCarbodyAnnotation();

    /**
     * private constructor.
     */
    private DCarbodyAnnotation() {
        this.logger = LoggerFactory.getLogger(DCarbodyAnnotation.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DCarbodyAnnotation getInstance() {
        return INSTANCE;
    }

}
