package ru.job4j.jdbc.tracker;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tracker test.
 */
public class TrackerTest {
    /**
     * Test add.
     * @throws Exception exception
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (Tracker tracker = new Tracker()) {
            Item item = new Item("Moscow", "desc", 123L);
            int expect = tracker.size();
            tracker.add(item);
            int result = tracker.size();
            assertThat(result, is(expect + 1));
        }
    }

    /**
     * Test delete.
     * @throws Exception exception
     */
    @Test
    public void whenDeleteItemThenSizeIsReduced() throws Exception {
        try (Tracker tracker = new Tracker()) {
            Item item = new Item("Moscow", "desc", 123L);
            int expect = tracker.size();
            tracker.add(item);
            tracker.delete(item);
            int result = tracker.size();
            assertThat(result, is(expect));
        }
    }

    /**
     * Test update.
     * @throws Exception exception
     */
    @Test
    public void whenUpdateOldItemThenOldItemReplacNewItem() throws Exception {
        try (Tracker tracker = new Tracker()) {
            Item item1 = new Item("Moscow", "desc", 123L);
            Item item2 = new Item("Saransk", "desc", 123L);
            tracker.add(item1);
            item2.setId(item1.getId());
            tracker.update(item2);
            String result = tracker.findById(item1.getId());
            assertThat(result, is("Saransk"));
        }
    }
}