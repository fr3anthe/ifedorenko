package ru.job4j.collections.task322;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 */
public class UserConvert {
    /**
     * Main method in class. Convert from List<User> to HashMap<Integer, User>
     * @param list List<User>
     * @return HashMap<Integer, User>
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
