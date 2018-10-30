package ru.job4j.car.model.dao.annotation;

import org.slf4j.LoggerFactory;
import ru.job4j.car.model.dao.DAOAbstract;
import ru.job4j.car.model.entities.annotation.CarAnnotation;

public class DCarAnnotation extends DAOAbstract<CarAnnotation> {
    /**
     * Singleton instance
     */
    private static final DCarAnnotation INSTANCE = new DCarAnnotation();

    /**
     * Private constructor.
     */
    private DCarAnnotation() {
        this.logger = LoggerFactory.getLogger(DCarAnnotation.class);
    }

    /**
     * Method getInstance.
     *
     * @return INSTANCE
     */
    public static DCarAnnotation getInstance() {
        return INSTANCE;
    }
}
