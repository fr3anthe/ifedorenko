package ru.job4j;

import ru.job4j.model.entity.User;
import ru.job4j.model.storage.UserStorage;

/**
 * class ImportUser.
 *
 * @author ifedorenko
 * @since 09.04.2019
 */
public class ImportUser {
    private UserStorage us;

    /**
     * Constructor.
     * @param us userStorage impl.
     */
    public ImportUser(UserStorage us) {
        this.us = us;
    }

    /**
     * Method addUser
     * @param user user for adding
     * @return id
     */
    public int addUser(User user) {
       return this.us.addUser(user);
    }
}
