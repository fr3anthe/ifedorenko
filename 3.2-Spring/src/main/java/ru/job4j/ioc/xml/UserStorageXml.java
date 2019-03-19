package ru.job4j.ioc.xml;

import ru.job4j.Storage;
import ru.job4j.User;

/**
 * Class UserStorage
 */
public class UserStorageXml {
    private final Storage storage;

    /**
     * Constructor.
     * @param storage storage
     */
    public UserStorageXml(Storage storage) {
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
