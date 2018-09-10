package ru.job4j.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class SpaceX.
 */
public class SpaceX implements Creator {

    @Override
    public Product manage() {
        return new Falcon9();
    }
}
