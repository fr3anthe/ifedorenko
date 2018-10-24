package ru.job4j.configuration.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.save(item);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            tx.rollback();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void update(Item item) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.update(item);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            tx.rollback();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            Item item = new Item();
            item.setId(id);
            session.delete(item);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            tx.rollback();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Item getById(int id) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        Item temp = null;
        try {
            temp = session.get(Item.class, id);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            tx.rollback();
        } finally {
            tx.commit();
            session.close();
            return temp;
        }
    }

    @Override
    public List<Item> getAll() {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        List<Item> items = null;
        try {
            items = session.createQuery("from ru.job4j.configuration.models.entities.Item").getResultList();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            tx.rollback();
        } finally {
            tx.commit();
            session.close();
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
