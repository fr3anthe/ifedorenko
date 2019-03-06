package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entities.User;
import java.util.List;

/**
 * class DUser.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
public class DUser extends DAOAbstract<User> {
    private static final DUser INSTANCE = new DUser();

    /**
     * Private Constructor
     */
    private DUser() {
        this.logger = LoggerFactory.getLogger(DUser.class);
    }
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DUser.class);

    @Override
    public User getById(int id) {
        return this.tx(session -> session.get(User.class, id));
    }

    @Override
    public List<User> getAll() {
        return this.tx(session -> session.createQuery("from ru.job4j.model.entities.User").getResultList());
    }

    /**
     * Get by name.
     * @param login name for get.
     * @return user's list
     */
    public List<User> getByLogin(String login) {
        return this.tx(session -> {
            Query query = session.createQuery("from User where login =: login");
            query.setParameter("login", login);
            return (List<User>) query.list();
        });
    }

    /**
     * Method getInstance.
     * @return INSTANCE
     */
    public static DUser getInstance() {
        return INSTANCE;
    }
}
