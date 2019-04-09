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

    public List<Advertisement> getByLastDay() {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement where date > :date");
            query.setParameter("date", new Timestamp(System.currentTimeMillis() - 86400000));
            return query.list();
        });
    }

    public List<Advertisement> getAllWithPhoto() {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement where image = :image");
            query.setParameter("image", true);
            return query.list();
        });
    }

    /**
     * Method getAllByModel.
     * @param model model
     * @return list
     */
    public List<Advertisement> getAllByModel(String model) {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement a where a.car.model = :model");
            query.setParameter("model", model);
            return query.list();
        });
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DAdvertisement getInstance() {
        return INSTANCE;
    }
}
