package ru.job4j.patterns.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadSafeSingleton.
 */
public class ThreadSafeSingleton {
    static final ThreadSafeSingleton SINGLETON = new ThreadSafeSingleton();

    /**
     * Constructor.
     */
    private ThreadSafeSingleton() {

    }

    /**
     * Method getInstance.
     * @return singleton
     */
    public static ThreadSafeSingleton getInstance() {
        return SINGLETON;
    }
}
