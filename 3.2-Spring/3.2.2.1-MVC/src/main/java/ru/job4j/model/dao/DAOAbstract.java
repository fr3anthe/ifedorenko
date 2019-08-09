package ru.job4j.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import ru.job4j.model.entities.Entity;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;
import java.util.function.Function;

/**
 * Class DAOAbstract.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
public abstract class DAOAbstract<E extends Entity> implements DAO<E> {
    protected final SessionFactory factory;
    protected Logger logger;

    /**
     * Constructor
     * @param factory db factory
     */
    public DAOAbstract(HibernateFactory factory) {
        this.factory = factory.getFactory();
    }

    @Override
    public int add(E add) {
        int temp = -1;
        try {
            temp = this.tx(session -> {
                session.save(add);
                return add.getId();
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public int update(E update) {
        int temp = -1;
        try {
            temp = this.tx(session -> {
                session.update(update);
                return update.getId();
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public int delete(E delete) {
        int temp = -1;
        try {
            temp = this.tx(session -> {
                session.delete(delete);
                return delete.getId();
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return temp;
    }

    @Override
    public abstract E getById(int id);

    @Override
    public abstract List<E> getAll();

    /**
     * Method for wrapper.
     * @param command functional interface for lambda
     * @param <T> return type.
     * @return param T
     */
    public <T> T tx(final Function<Session, T> command) {
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
}
