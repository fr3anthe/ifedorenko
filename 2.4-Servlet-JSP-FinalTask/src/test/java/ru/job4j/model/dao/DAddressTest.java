package ru.job4j.model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.model.entities.Address;
import static org.junit.Assert.*;

public class DAddressTest {
    private Address address;
    private DAddress addr = DAddress.getInstance();

    /**
     * Before.
     */
    @Before
    public void before() {
        address = new Address("Kiev");
        addr.add(address);
    }

    /**
     * After.
     */
    @After
    public void after() {
        addr.delete(address.getId());
    }

    /**
     * Test add.
     */
    @Test
    public void add() {
        Address result = addr.getById(address.getId());
        assertEquals(address, result);
    }

    /**
     * Test update.
     */
    @Test
    public void update() {
        String name = "Paris";
        address.setName(name);
        addr.update(address);
        Address result = addr.getById(address.getId());
        assertEquals(name, result.getName());
    }

    /**
     * Test delete.
     */
    @Test
    public void delete() {
        Address temp = new Address("LA");
        addr.add(temp);
        int size = addr.getAll().size();
        addr.delete(temp.getId());
        int result = addr.getAll().size();
        assertEquals(size - 1, result);
    }

    /**
     * Test getById.
     */
    @Test
    public void getById() {
        Address temp = addr.getById(address.getId());
        assertEquals(address, temp);
    }
}