package ru.job4j.configuration.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.configuration.models.database.HibernateFactory;
import ru.job4j.configuration.models.entities.Item;

import java.util.List;
import java.util.function.Function;

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
    public int add(final Item item) {
        int temp = -1;
        try {
           temp = this.tx(session -> {
                session.save(item);
                return item.getId();
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public int update(final Item item) {
        int temp = -1;
        try {
            temp = this.tx(session -> {
                session.update(item);
                return item.getId();
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public int delete(final int id) {
        int temp = -1;
        Item delete = new Item();
        delete.setId(id);
        try {
            temp = this.tx(session -> {
                session.delete(delete);
                return id;
            });
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public Item getById(final int id) {
        return this.tx(session -> session.get(Item.class, id));
    }

    @Override
    public List<Item> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.configuration.models.entities.Item").getResultList());
    }

    /**
     * Method for wrapper.
     * @param command functional interface for lambda
     * @param <T> return type.
     * @return param T
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
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
