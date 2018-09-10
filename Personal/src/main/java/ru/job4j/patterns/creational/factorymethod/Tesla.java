package ru.job4j.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Tesla.
 */
public class Tesla implements Creator {

    @Override
    public Product manage() {
        return new TeslaRoadster();
    }
}
