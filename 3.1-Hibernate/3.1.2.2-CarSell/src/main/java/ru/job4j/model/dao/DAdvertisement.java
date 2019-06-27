package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.Advertisement;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class DAdvertisement.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
public class DAdvertisement extends DAOAbstract<Advertisement> {
    private static final DAdvertisement INSTANCE = new DAdvertisement();

    /**
     * Private Constructor
     */
    private DAdvertisement() {
        this.logger = LoggerFactory.getLogger(DAdvertisement.class);
    }

    @Override
    public Advertisement getById(int id) {
        return this.tx(session -> session.get(Advertisement.class, id));
        }


    @Override
    public List<Advertisement> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.Advertisement").getResultList());
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DAdvertisement getInstance() {
        return INSTANCE;
    }
}
