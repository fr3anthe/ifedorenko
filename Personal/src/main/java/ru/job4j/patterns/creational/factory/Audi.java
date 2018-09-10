package ru.job4j.patterns.creational.factory;

/**
 * Class Audi for factory.
 */
public class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}
