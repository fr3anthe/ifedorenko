package ru.job4j.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Falcon9.
 */
public class Falcon9 implements Product {

    @Override
    public void make() {
        System.out.println("Make Falcon9");
    }
}
