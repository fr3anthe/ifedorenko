package ru.job4j.car.model.dao.xml;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.xml.CarbodyXML;

import static org.junit.Assert.*;

public class DCarbodyXMLTest {
    private DCarbodyXML carbodies = DCarbodyXML.getInstance();
    private CarbodyXML carbody;

    /**
     * Before method.
     */
    @Before
    public void before() {
        carbody = new CarbodyXML();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DCarbodyXML expect = DCarbodyXML.getInstance();
        assertSame(expect, carbodies);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddCarbodyThenGetId() {
        carbody.setName("SedanX");
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
        carbody.setName("HatchbackX");
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
        carbody.setName("MpvX");
        int id = carbodies.add(carbody);
        carbody.setName("SuvX");
        int expect = carbodies.update(carbody);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}
