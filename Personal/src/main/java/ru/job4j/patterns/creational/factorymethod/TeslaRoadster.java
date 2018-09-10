package ru.job4j.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class TeslaRoadster.
 */
public class TeslaRoadster implements Product {

    @Override
    public void make() {
        System.out.println("Make TeslaRoadster");
    }
}
