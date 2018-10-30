package ru.job4j.car.model.dao.xml;

import org.junit.Before;
import org.junit.Test;

import ru.job4j.car.model.entities.xml.CarXML;

import static org.junit.Assert.*;

public class DCarXMLTest {
    private DCarXML cars = DCarXML.getInstance();
    private CarXML car;

    /**
     * Before method.
     */
    @Before
    public void before() {
        car = new CarXML();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DCarXML expect = DCarXML.getInstance();
        assertSame(expect, cars);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddCarThenGetId() {
        car.setName("ToyotaX");
        int expect = cars.add(car);
        assertEquals(expect, car.getId());
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success delete.
     */
    @Test
    public void whenDeleteCarThendGetPositiveInt() {
        car.setName("BmwX");
        int id = cars.add(car);
        int expect = cars.delete(car);
        assertEquals(expect, id);
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success update.
     */
    @Test
    public void whenUpdateCarThenGetPositiveInt() {
        car.setName("SubaruX");
        int id = cars.add(car);
        car.setName("KiaX");
        int expect = cars.update(car);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}