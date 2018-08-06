package ru.job4j.servlets.http;

import java.util.List;
import java.util.NoSuchElementException;

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
     * id
     */
    private int idCount = 0;
    /**
     * Store
     */
    private final Store store = MemoryStore.getInstance();

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
    public void add(String name, String login, String email) {
        synchronized (this) {
            store.add(new User(idCount++, name, login, email));
        }
    }

    /**
     * update user from store.
     * @param id for find user
     * @param name for updating
     * @param email for updating
     */
    public void update(int id, String name, String email) {
        store.update(id, name, email);
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

    /**
     * Get ValidateService.
     * @return ValidateService instance.
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }
}
