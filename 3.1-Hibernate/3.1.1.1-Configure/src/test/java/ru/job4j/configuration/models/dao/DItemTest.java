package ru.job4j.configuration.models.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.configuration.models.database.HibernateFactory;
import ru.job4j.configuration.models.entities.Item;
import static org.junit.Assert.*;

public class DItemTest {
    private Item item;
    private DItem store = DItem.getInstance();
    /**
     * Before test.
     */
    @Before
    public void before() {
        item = new Item();
        item.setDesc("test");
        item.setDone(false);
        store.add(item);
    }

    /**
     * After test.
     */
    @After
    public void after() {
        store.delete(item.getId());
    }

    /**
     * After all test.
     */
    @AfterClass
    public static void afterAll() {
        HibernateFactory.getInstance().close();
    }

    /**
     * Test add.
     */
    @Test
    public void add() {
        Item expect = store.getById(item.getId());
        assertEquals(expect, item);
    }

    /**
     * Test update.
     */
    @Test
    public void update() {
        item.setDone(true);
        store.update(item);
        boolean expect = store.getById(item.getId()).isDone();
        assertEquals(expect, true);
    }

    /**
     * Test delete.
     */
    @Test
    public void delete() {
        Item temp = new Item();
        temp.setDesc("delete");
        store.add(temp);
        int size = store.getAll().size();
        store.delete(temp.getId());
        int expect = store.getAll().size();
        assertEquals(expect, size - 1);
    }

    /**
     * Test getById.
     */
    @Test
    public void getById() {
        String expect =  store.getById(item.getId()).getDesc();
        assertEquals(expect, item.getDesc());
    }

    /**
     * Test getAll.
     */
    @Test
    public void getAll() {
        int size = store.getAll().size();
        Item temp = new Item();
        temp.setDesc("delete");
        store.add(temp);
        int expect = store.getAll().size();
        assertEquals(expect, size + 1);
    }

    /**
     * Test getInstance.
     */
    @Test
    public void getInstance() {
        DItem expect = DItem.getInstance();
        assertEquals(expect, store);
    }
}