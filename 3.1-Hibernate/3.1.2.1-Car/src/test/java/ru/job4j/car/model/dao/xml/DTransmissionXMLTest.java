package ru.job4j.car.model.dao.xml;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.xml.TransmissionXML;

import static org.junit.Assert.*;

public class DTransmissionXMLTest {
    private DTransmissionXML transmissions = DTransmissionXML.getInstance();
    private TransmissionXML transmission;

    /**
     * Before method.
     */
    @Before
    public void before() {
        transmission = new TransmissionXML();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DTransmissionXML expect = DTransmissionXML.getInstance();
        assertSame(expect, transmissions);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddTransmissionThenGetId() {
        transmission.setName("AutoX");
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
        transmission.setName("MechX");
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
        transmission.setName("RobotX");
        int id = transmissions.add(transmission);
        transmission.setName("VarX");
        int expect = transmissions.update(transmission);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}