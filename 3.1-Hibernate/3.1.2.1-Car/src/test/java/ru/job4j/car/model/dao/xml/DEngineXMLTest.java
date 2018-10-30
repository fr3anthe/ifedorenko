package ru.job4j.car.model.dao.xml;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.xml.EngineXML;
import static org.junit.Assert.*;

public class DEngineXMLTest {
    private DEngineXML engines = DEngineXML.getInstance();
    private EngineXML engine;

    /**
     * Before method.
     */
    @Before
    public void before() {
        engine = new EngineXML();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DEngineXML expect = DEngineXML.getInstance();
        assertSame(expect, engines);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddEngineThenGetId() {
        engine.setName("ComboX");
        int expect = engines.add(engine);
        assertEquals(expect, engine.getId());
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success delete.
     */
    @Test
    public void whenDeleteEngineThendGetPositiveInt() {
        engine.setName("ElectroX");
        int id = engines.add(engine);
        int expect = engines.delete(engine);
        assertEquals(expect, id);
        boolean result = expect > 0;
        assertEquals(result, true);
    }

    /**
     * Test success update.
     */
    @Test
    public void whenUpdateEngineThenGetPositiveInt() {
        engine.setName("SteamX");
        int id = engines.add(engine);
        engine.setName("PistonX");
        int expect = engines.update(engine);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}