package ru.job4j.configuration.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.configuration.models.database.HibernateFactory;
import ru.job4j.configuration.models.entities.Item;

import java.util.List;

/**
 * Class DItem implements DAO for item.
 *
 * @author ifedorenko
 * @since 12.10.2018
 */
public class DItem implements DAO<Item> {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DItem.class);
    /**
     * Singleton instance
     */
    private static final DItem INSTANCE = new DItem();
    private final SessionFactory factory;

    /**
     * Constructor.
     */
    private DItem() {
        factory = HibernateFactory.getInstance().getFactory();
    }

    @Override
    public void add(Item item) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Item item) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Item item = new Item();
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public Item getById(int id) {
        Item temp = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            temp = session.get(Item.class, id);
            session.getTransaction().commit();
        } finally {
            return temp;
        }
    }

    @Override
    public List<Item> getAll() {
        List<Item> items = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            items = session.createQuery("from ru.job4j.configuration.models.entities.Item").getResultList();
            session.getTransaction().commit();
        } finally {
            return items;
        }
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DItem getInstance() {
        return INSTANCE;
    }
}
