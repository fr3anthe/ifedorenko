package ru.job4j.servlets.http;

import java.util.List;

/**
 * Class ValidateService. Singleton.
 *
 * @author ifedorenko
 * @since 27.07.2018
 */
public class ValidateService {
    /**
     * Singleton variable
     */
    private static final ValidateService INSTANCE = new ValidateService();
    /**
     * Store
     */
    private final DBStore store = DBStore.getInstance();

    /**
     * Private cosntructor for Singleton
     */
    private ValidateService() {
    }

    /**
     *  add user in store.
     * @param name name for user
     * @param login login for user
     * @param email email for user
     */
    public void add(String name, String login, String email, String role, String password) {
            store.add(new User(name, login, email, role, password));
    }

    /**
     * update user from store.
     * @param login for find user
     * @param name for updating
     * @param email for updating
     * @param role for updating
     * @param password for updating
     */
    public void update(String login, String name, String email, String role, String password) {
        store.update(login, name, email, role, password);
    }

    /**
     * delete user from store.
     * @param id use for find user for deleting
     */
    public void delete(int id) {
        store.delete(id);
    }

    /**
     * find all user in store.
     * @return list with all user
     */
    public List<User> findAll() {
        return store.findAll();
    }

    /**
     * find user using id.
     * @param id id for finding.
     * @return result
     */
    public User findById(int id) {
        return store.findById(id);
    }

    public User findByLogin(String login) {
        return store.findByLogin(login);
    }

    public boolean isCredential(String login, String password) {
        boolean exists = false;
        for (User user : store.findAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    /**
     * Get ValidateService.
     * @return ValidateService instance.
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }
}
