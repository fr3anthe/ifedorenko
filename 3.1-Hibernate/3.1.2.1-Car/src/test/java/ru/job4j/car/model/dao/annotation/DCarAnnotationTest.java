package ru.job4j.car.model.dao.annotation;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.annotation.CarAnnotation;


import static org.junit.Assert.*;

public class DCarAnnotationTest {
    private DCarAnnotation cars = DCarAnnotation.getInstance();
    private CarAnnotation car;

    /**
     * Before method.
     */
    @Before
    public void before() {
        car = new CarAnnotation();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DCarAnnotation expect = DCarAnnotation.getInstance();
        assertSame(expect, cars);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddCarThenGetId() {
        car.setName("ToyotaA");
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
        car.setName("BmwA");
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
        car.setName("SubaruA");
        int id = cars.add(car);
        car.setName("KiaA");
        int expect = cars.update(car);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}