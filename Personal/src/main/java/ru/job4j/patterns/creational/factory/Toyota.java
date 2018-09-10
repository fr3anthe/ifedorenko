package ru.job4j.patterns.creational.factory;

/**
 * Class Toyota for factory.
 */
public class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}
