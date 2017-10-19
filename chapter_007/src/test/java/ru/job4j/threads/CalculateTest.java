package ru.job4j.threads;

import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class CalculateTest.
 */
public class CalculateTest {
    /**
     * Test space.
     */
    @Test
    public void whenStringHasThreeSpacesThenThreadReturnInfoAboutThreeSpeces() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String word = "Закрыло пеленой чреду воспоминаний";
        Runnable sc = new SpaceCount(word);

        sc.run();

        String excepted = "Spaces: 3";
        assertThat(os.toString(), is(excepted));
    }

    /**
     * Test word.
     */
    @Test
    public void whenStringHasFourWordsThenThreadReturnInfoAboutFourWords() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String word = "Закрыло пеленой чреду воспоминаний";
        Runnable wc = new WordCount(word);

        wc.run();

        String excepted = "Words: 4";
        assertThat(os.toString(), is(excepted));
    }

}