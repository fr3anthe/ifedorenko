package ru.job4j.controltask.extra;

/**
 * Class DeadLock
 */
public class DeadLock {
    /**
     * Method main.
     * @param args args
     * @throws InterruptedException exception
     */
    public static void main(String[] args) throws InterruptedException {
        /**
         * @param A Object for lock
         */
        Object a = new Object();
        /**
         * @param B Object for lock
         */
        Object b = new Object();

        Thread thA = new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + " lock A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try lock B");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " lock A and B");
                }

            }
        });

        Thread thB = new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + " lock B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try lock A");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " lock A and B");
                }

            }
        });

        thA.setName("first");
        thB.setName("second");

        thA.start();
        thB.start();

        thA.join();
        thB.join();
    }
}
