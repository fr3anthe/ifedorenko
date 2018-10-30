package ru.job4j.car.model.dao.annotation;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.model.entities.annotation.EngineAnnotation;


import static org.junit.Assert.*;

public class DEngineAnnotationTest {
    private DEngineAnnotation engines = DEngineAnnotation.getInstance();
    private EngineAnnotation engine;

    /**
     * Before method.
     */
    @Before
    public void before() {
        engine = new EngineAnnotation();
    }

    /**
     * Test singleton.
     */
    @Test
    public void testSingleton() {
        DEngineAnnotation expect = DEngineAnnotation.getInstance();
        assertSame(expect, engines);
    }

    /**
     * Test success add.
     */
    @Test
    public void whenAddEngineThenGetId() {
        engine.setName("ComboA");
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
        engine.setName("ElectroA");
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
        engine.setName("SteaA");
        int id = engines.add(engine);
        engine.setName("PistonA");
        int expect = engines.update(engine);
        assertEquals(id, expect);
        boolean result = expect > 0;
        assertEquals(result, true);
    }
}