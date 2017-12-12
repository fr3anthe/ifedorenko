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

        String excepted = "Spaces: 3\r\n";
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

        String excepted = "Words: 4\r\n";
        assertThat(os.toString(), is(excepted));
    }

    /**
     * Test space sequence.
     */
    @Test
    public void whenWeHaveAStrictASequenceThenStartFirstSpaceCountSecondAndEndThird() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String word = "Закрыло пеленой чреду воспоминаний";
        Thread space = new Thread(new SpaceCount(word));

        System.out.println("Start");
        space.start();
        while (space.isAlive()) {
            continue;
        }
        System.out.println("End");

        String excepted1 = "Start\r\n";
        String excepted2 = "Spaces: 3\r\n";
        String excepted3 = "End\r\n";
        assertThat(os.toString(), is(excepted1 + excepted2 + excepted3));
    }

    /**
     * Test word sequence.
     */
    @Test
    public void whenWeHaveAStrictASequenceThenStartFirstWordCountSecondAndEndThird() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String word = "Закрыло пеленой чреду воспоминаний";
        Thread wc = new Thread(new WordCount(word));

        System.out.println("Start");
        wc.start();
        while (wc.isAlive()) {
            continue;
        }
        System.out.println("End");

        String excepted1 = "Start\r\n";
        String excepted2 = "Words: 4\r\n";
        String excepted3 = "End\r\n";
        assertThat(os.toString(), is(excepted1 + excepted2 + excepted3));
    }

}