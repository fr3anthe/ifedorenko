package ru.job4j.car.model.dao.annotation;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.annotation.EngineAnnotation;

/**
 * class DEngineAnnotation.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public class DEngineAnnotation extends DAOAbstract<EngineAnnotation> {
    /**
     * Singleton instance
     */
    private static final DEngineAnnotation INSTANCE = new DEngineAnnotation();

    /**
     * private constructor.
     */
    private DEngineAnnotation() {
        this.logger = LoggerFactory.getLogger(DEngineAnnotation.class);
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DEngineAnnotation getInstance() {
        return INSTANCE;
    }
}
