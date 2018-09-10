package ru.job4j.patterns.creational.prototype;

/**
 * Interface Pizza.
 */
public interface Pizza extends Cloneable {
    /**
     * Method make.
     * @return pizza
     * @throws CloneNotSupportedException exception
     */
    Pizza make() throws CloneNotSupportedException;
}
