package ru.job4j.patterns.creational.singleton;

/**
 * NotThreadSafeSingleton
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class NotThreadSafeSingleton  {
    private static NotThreadSafeSingleton instance;

    /**
     * Constructor.
     */
    private NotThreadSafeSingleton() { };

    /**
     * Method getInstance.
     * @return NotThreadSafeSingleton
     */
    public static NotThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new NotThreadSafeSingleton();
        }
        return instance;
    }
}
