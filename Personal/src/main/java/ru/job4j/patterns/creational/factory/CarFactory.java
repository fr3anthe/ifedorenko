package ru.job4j.patterns.creational.factory;

/**
 * Class CarFactory.
 */
public class CarFactory implements ru.job4j.patterns.creational.factory.Factory {
    @Override
    public Car createCar(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota":
                return new Toyota();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }
}
