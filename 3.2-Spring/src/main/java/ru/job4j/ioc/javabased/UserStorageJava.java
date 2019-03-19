package ru.job4j.ioc.javabased;

import ru.job4j.Storage;
import ru.job4j.User;

/**
 * Class UserStorage
 */
public class UserStorageJava {
    private final Storage storage;

    /**
     * Constructor.
     * @param storage storage
     */
    public UserStorageJava(Storage storage) {
        this.storage = storage;
    }

    /**
     * Add user.
     * @param user user for adding
     * @return message.
     */
    public String add(User user) {
        return this.storage.add(user);
    }
}
