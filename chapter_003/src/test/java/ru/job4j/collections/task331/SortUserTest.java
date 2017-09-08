package ru.job4j.collections.task331;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest.
 * @author Igor Fedorenko (mailto:if.zommy@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    /**
     * Test sort.
     */
    @Test
    public void whenAddListOfUserThenReturnSortedSetByAge() {
        SortUser su = new SortUser();
        User user1 = new User("Andrey", 23);
        User user2 = new User("Masha", 25);
        User user3 = new User("Igor", 29);
        User user4 = new User("Dasha", 21);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        Set<User> expect = new TreeSet<>();
        expect.add(user1);
        expect.add(user2);
        expect.add(user3);
        expect.add(user4);

        Set<User> result = su.sort(list);
        assertThat(result, is(expect));
    }

}
