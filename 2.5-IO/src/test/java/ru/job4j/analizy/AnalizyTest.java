package ru.job4j.analizy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class AnalizyTest {
    private static final String SOURCE = "src/test/resources/log.txt";
    private static final String TARGET = "src/test/resources/unavailable.csv";
    private static final String FIRST_PERIOD = "10:57:01;10:59:01";
    private static final String SECOND_PERIOD = "11:01:02;11:02:02";
    private File target;

    /**
     * Before every method init target file.
     */
    @Before
    public void initTarget() {
        this.target = new File(TARGET);
    }

    /**
     * After every method delete target file.
     */
    @After
    public void deleteTarget() {
        this.target.delete();
    }

    /**
     * Test №1.
     */
    @Test
    public void testTargetCreating() {
        assertTrue(!this.target.exists());
        Analizy analizy = new Analizy();
        analizy.unavailable(SOURCE, TARGET);
        assertTrue(this.target.exists());
        assertTrue(this.target.length() > 0);
    }

    /**
     * Test №2.
     * @throws IOException exception
     */
    @Test
    public void testRightDate() throws IOException {
        Analizy analizy = new Analizy();
        analizy.unavailable(SOURCE, TARGET);
        try (BufferedReader reader = new BufferedReader(new FileReader(this.target))) {
            String line = reader.readLine();
            assertTrue(line.equals(FIRST_PERIOD));
            line = reader.readLine();
            assertTrue(line.equals(SECOND_PERIOD));
            line = reader.readLine();
            assertTrue(line == null);
        }
    }
}