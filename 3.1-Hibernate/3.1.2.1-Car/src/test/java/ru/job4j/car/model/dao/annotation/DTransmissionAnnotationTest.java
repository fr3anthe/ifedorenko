package ru.job4j.car.model.dao.annotation;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.annotation.TransmissionAnnotation;


import static org.junit.Assert.*;

public class DTransmissionAnnotationTest {
    private DTransmissionAnnotation transmissions = DTransmissionAnnotation.getInstance();
    private TransmissionAnnotation transmission;

    /**
     * Before method.
     */
    @Before
    public void before() {
        transmission = new TransmissionAnnotation();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DTransmissionAnnotation expect = DTransmissionAnnotation.getInstance();
        assertSame(expect, transmissions);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddTransmissionThenGetId() {
        transmission.setName("AutoA");
        int expect = transmissions.add(transmission);
        assertEquals(expect, transmission.getId());
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success delete.
     */
    @Test
    public void whenDeleteTransmissionThendGetPositiveInt() {
        transmission.setName("MechA");
        int id = transmissions.add(transmission);
        int expect = transmissions.delete(transmission);
        assertEquals(expect, id);
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success update.
     */
    @Test
    public void whenUpdateTransmissionThenGetPositiveInt() {
        transmission.setName("RobotA");
        int id = transmissions.add(transmission);
        transmission.setName("VarA");
        int expect = transmissions.update(transmission);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}