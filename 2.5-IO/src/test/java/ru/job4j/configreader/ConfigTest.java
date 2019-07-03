package ru.job4j.configreader;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * class ConfigTest.
 */
public class ConfigTest {
    private Config config;
    private static final String PATH = "src/test/resources/app.properties";

    /**
     * Test №1.
     */
    @Test
    public void ifKeyUsernameThenValuePostgres() {
        config = new Config(PATH);
        config.load();
        String result = config.value("hibernate.connection.username");
        String expect = "postgres";
        assertEquals(expect, result);
    }

    /**
     * Test №2.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void ifKeyNoxExistThenError() {
        config = new Config(PATH);
        config.load();
        config.value("notExist");
    }
}