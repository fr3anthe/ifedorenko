package ru.job4j.personaltasks;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SearchCycleTest.
 */
public class SearchCycleTest {
    /**
     * Test Data has not cycle.
     */
    @Test
    public void whenDataHasNotCycleThenRslEmpty() {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 2);
        data.put(2, 3);
        data.put(3, 4);
        assertThat(new SearchCycle().search(data).isEmpty(), is(true));
    }

    /**
     * Test Data has single cycle.
     */
    @Test
    public void whenDataHasSingleCycleThenRslSingle() {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 2);
        data.put(2, 1);
        assertThat(
                new SearchCycle().search(data),
                is(Collections.singletonList(Arrays.asList(1, 2, 1)))
        );
    }

    /**
     * Test Data has multiple cycle.
     */
    @Test
    public void whenDataHasMultipleCycleThenRslMultiple() {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 2);
        data.put(2, 1);
        data.put(3, 4);
        data.put(4, 5);
        data.put(5, 3);
        assertThat(
                new SearchCycle().search(data),
                containsInAnyOrder(
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(3, 4, 5, 3)
                )
        );
    }
}
