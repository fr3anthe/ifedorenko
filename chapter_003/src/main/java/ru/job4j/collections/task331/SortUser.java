package ru.job4j.collections.task331;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *Class SortUser.
 *@author ifedorenko
 *@since 08.09.2017
 *@version 1
 */
public class SortUser {
    /**
     * Methdo sort.
     * @param list list of users
     * @return TreeSet
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }
}
