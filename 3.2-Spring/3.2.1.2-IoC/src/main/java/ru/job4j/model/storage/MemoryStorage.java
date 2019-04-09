package ru.job4j.model.storage;

import ru.job4j.model.entity.User;
import java.util.HashMap;
import java.util.Map;

/**
 * class MemoryStorage.
 */
public class MemoryStorage implements UserStorage {
    private Map<Integer, User> users = new HashMap<>();
    private int count = 0;

    @Override
    public int addUser(User user) {
        int result = -1;
        if (user != null) {
            this.users.put(count++, user);
            result = count;
        }
        return result;
    }
}
