package ru.job4j.javacode;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

/**
 * Class Test
 *
 * @author ifedorenko
 * @since 23.10.2018
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c1 = new CountDownLatch(5);
        CountDownLatch c2 = new CountDownLatch(5);

        Thread t1 = new Thread(new Task(c1, c2));
        Thread t2 = new Thread(new Task(c2, c1));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


    static class Task implements Runnable {
        private CountDownLatch a;
        private CountDownLatch b;
        private long size;


        public Task(CountDownLatch a, CountDownLatch b) {
            this.a = a;
            this.b = b;
            this.size = a.getCount();
        }

        @Override
        public void run() {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < size; i++) {
                b.countDown();
                System.out.println(Thread.currentThread().getName() + " " + i + " lap");
            }
        }
    }
}
