package ru.job4j.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.Storage;
import ru.job4j.User;

/**
 * Class UserStorage
 */
@Component
public class UserStorageAnnotation {
    private final Storage storage;

    /**
     * Constructor.
     * @param storage storage
     */
    @Autowired
    public UserStorageAnnotation(Storage storage) {
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
