package ru.job4j.patterns.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Toyota for factory.
 */
public class T51 implements Tank {
    @Override
    public void drive() {
        System.out.println("drive T51");
    }
}
