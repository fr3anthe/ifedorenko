package ru.job4j.servlets.http;

import java.util.List;

/**
 * Interface Store.
 * @author ifedorenko
 * @since 27.07.2018
 */
public interface Store {
    /**
     * add.
     * @param user for adding
     */
    void add(User user);

    /**
     * update.
     * @param id use for find user
     * @param name name for update
     * @param email email for update
     */
    void update(int id, String name, String email);

    /**
     * delete.
     * @param id use for find user.
     */
    void delete(int id);

    /**
     * findAll.
     * @return all user.
     */
    List<User> findAll();

    /**
     * findById.
     * @param id use for find user
     * @return user
     */
    User findById(int id);
}
