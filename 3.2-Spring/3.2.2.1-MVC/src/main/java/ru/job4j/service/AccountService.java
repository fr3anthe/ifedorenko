package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.model.dao.DUser;
import ru.job4j.model.entities.User;
import java.util.Optional;

/**
 *
 */
@Component
@Scope("singleton")
public class AccountService {
    private DUser dUser;

    /**
     * Constructor.
     * @param dUser DUser
     */
    @Autowired
    public AccountService(DUser dUser) {
        this.dUser = dUser;
    }

    /**
     * User autorization.
     * @param user user
     * @return result
     */
    public boolean isUserCredential(User user) {
        boolean result = false;
        Optional<User> oUser = dUser.getAll().stream().filter(user::equals).findFirst();
        if (oUser.isPresent()) {
            user.setId(oUser.get().getId());
            result = true;
        }
        return result;
    }

    /**
     * Check users exist.
     * @param user login for check
     * @return result
     */
    public boolean isUserExist(User user) {
        boolean result = true;
        if (dUser.getByLogin(user.getLogin()).size() == 0) {
            result = false;
        }
        return result;
    }

    /**
     * Add user to db.
     * @param user user to adding
     */
    public void addUser(User user) {
        dUser.add(user);
    }
}
