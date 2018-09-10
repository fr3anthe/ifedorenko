package ru.job4j.patterns.creational.singleton;

/**
 * SingletonPattern.
 *
 * Задача создания единственного экземпляра классаю
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class SingletonPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));

        NotThreadSafeSingleton singleton3 = NotThreadSafeSingleton.getInstance();
        NotThreadSafeSingleton singleton4 = NotThreadSafeSingleton.getInstance();
        System.out.println(singleton3.equals(singleton4));
    }
}

