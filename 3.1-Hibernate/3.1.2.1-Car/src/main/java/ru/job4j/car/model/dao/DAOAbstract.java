package ru.job4j.car.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import ru.job4j.car.model.database.HibernateFactory;
import ru.job4j.car.model.entities.Entity;

import java.util.function.Function;

/**
 * abstract class DAOAbstract.
 *
 * @author ifedorenko
 * @since 30.10.2018
 */
public abstract class DAOAbstract<E extends Entity> implements DAO<E> {
    protected final SessionFactory factory;
    protected Logger logger;

    /**
     * Constrcutor.
     */
    public DAOAbstract() {
        this.factory = HibernateFactory.getInstance().getFactory();
    }

    /**
     * add.
     * @param add object for adding;
     * @return id or -1;
     */
    public int add(final E add) {
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

    /**
     * update.
     * @param update object for updating
     * @return id or -1;
     */
    public int update(final E update) {
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

    /**
     * delete.
     * @param delete object for deleting
     * @return return id or -1;
     */
    public int delete(final E delete) {
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

    /**
     * closeFactory.
     */
    public void closeFactory() {
        factory.close();
    }
}
