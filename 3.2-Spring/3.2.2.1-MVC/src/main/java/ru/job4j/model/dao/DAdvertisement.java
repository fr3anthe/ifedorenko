package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.Advertisement;
import ru.job4j.model.hibernate.HibernateFactory;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class DAdvertisement.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Component
@Scope("singleton")
public class DAdvertisement extends DAOAbstract<Advertisement> {
    /**
     * Constructor
     * @param factory db factory
     */
    @Autowired
    public DAdvertisement(HibernateFactory factory) {
        super(factory);
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
     * Метод для фильтрации.
     * @return все заявки за последний день.
     */
    public List<Advertisement> getByLastDay() {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement where date > :date");
            query.setParameter("date", Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
            return query.list();
        });
    }

    /**
     * Метод для фильтрации.
     * @return все заявки с фотографиями.
     */
    public List<Advertisement> getAllWithPhoto() {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement where image = :image");
            query.setParameter("image", true);
            return query.list();
        });
    }

    /**
     * Метод для фильтрации.
     * @param model модель машины
     * @return все заявки по заданной модели.
     */
    public List<Advertisement> getAllByModel(String model) {
        return this.tx(session -> {
            Query query = session.createQuery("from ru.job4j.model.entities.Advertisement a where a.car.model = :model");
            query.setParameter("model", model);
            return query.list();
        });
    }
}
