package ru.job4j.car.model.dao.annotation;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.annotation.CarbodyAnnotation;


import static org.junit.Assert.*;

public class DCarbodyAnnotationTest {
    private DCarbodyAnnotation carbodies = DCarbodyAnnotation.getInstance();
    private CarbodyAnnotation carbody;

    /**
     * Before method.
     */
    @Before
    public void before() {
        carbody = new CarbodyAnnotation();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DCarbodyAnnotation expect = DCarbodyAnnotation.getInstance();
        assertSame(expect, carbodies);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddCarbodyThenGetId() {
        carbody.setName("SedanA");
        int expect = carbodies.add(carbody);
        assertEquals(expect, carbody.getId());
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success delete.
     */
    @Test
    public void whenDeleteCarbodyThendGetPositiveInt() {
        carbody.setName("HatchbackA");
        int id = carbodies.add(carbody);
        int expect = carbodies.delete(carbody);
        assertEquals(expect, id);
        boolean result = expect > 0;
        assertEquals(result, true);

    }

    /**
     * Test success update.
     */
    @Test
    public void whenUpdateCarbodyThenGetPositiveInt() {
        carbody.setName("MpvA");
        int id = carbodies.add(carbody);
        carbody.setName("SuvA");
        int expect = carbodies.update(carbody);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}