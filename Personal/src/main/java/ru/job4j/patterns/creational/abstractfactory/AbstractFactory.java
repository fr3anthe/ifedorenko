package ru.job4j.patterns.creational.abstractfactory;

/**
 * class AbstractFactory.
 */
public class AbstractFactory {
    /**
     * method reateFactory.
     * @param typeOfFactory factory's type
     * @return factory's object
     */
    Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Car":
                return new CarFactory();
            case "Tank":
                return new TankFactory();
            default:
                return null;
        }
    }
}
