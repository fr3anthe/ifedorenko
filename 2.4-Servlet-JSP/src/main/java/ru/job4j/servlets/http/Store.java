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
     * @param login use for find user
     * @param name name for update
     * @param email email for update
     * @param role role for update
     * @param password password for update
     * @param country country for update
     * @param city city for update
     */
    void update(String login, String name, String email, String role, String password, String country, String city);

    /**
     * delete.
     * @param login use for find user.
     */
    void delete(String login);

    /**
     * findAll.
     * @return all user.
     */
    List<User> findAll();

    /**
     * findByLogin
     * @param login use for find user
     * @return n user
     */
    User findByLogin(String login);
}
