package ru.job4j.model.storage;


import ru.job4j.model.entity.User;

/**
 * Interface DAO.
 * @param
 */
public interface UserStorage {
    /**
     * Add User in db.
     * @param user object for adding
     * @return 1 if success, -1 if fail
     */
    int addUser(User user);
}
