package ru.job4j.controltask.extra;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SwitcherTest {
    private Switcher sw;
    private int cycle;

    private Thread thrA = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                while ((sw.length() / 10) % 2 == 1) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 10; j++) {
                    sw.add(1);
                }
            }
        }
    });

    private Thread thrB = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < cycle; i++) {
                while ((sw.length() / 10) % 2 == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 0; j < 10; j++) {
                    sw.add(2);
                }
            }
        }
    });

    /**
     * Test №1.
     * @throws InterruptedException exception
     */
    @Test
    public void whenWeAdd60ElementsThenTheLengthWillBe60() throws InterruptedException {
        sw = new Switcher();
        cycle = 3;
        thrA.start();
        thrB.start();
        thrA.join();
        thrB.join();
        int result = sw.length();
        int expect = 60;
        assertThat(result, is(expect));
    }

    /**
     * Test №2.
     * @throws InterruptedException exception
     */
    @Test
    public void whenWeAddElementsThenTheLengthWillBeConsistingRightSequence() throws InterruptedException {
        sw = new Switcher();
        cycle = 2;
        thrA.start();
        thrB.start();
        thrA.join();
        thrB.join();
        String result = sw.getStr();
        String expect = "1111111111222222222211111111112222222222";
        assertThat(result, is(expect));
    }
}