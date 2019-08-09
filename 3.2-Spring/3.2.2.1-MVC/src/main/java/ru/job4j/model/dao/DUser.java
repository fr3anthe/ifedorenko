package ru.job4j.model.dao;

import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.entities.User;
import ru.job4j.model.hibernate.HibernateFactory;

import java.util.List;

/**
 * class DUser.
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Component
@Scope("singleton")
public class DUser extends DAOAbstract<User> {
    /**
     * Constructor
     * @param factory db factory
     */
    public DUser(HibernateFactory factory) {
        super(factory);
        this.logger = LoggerFactory.getLogger(DUser.class);
    }

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
}
