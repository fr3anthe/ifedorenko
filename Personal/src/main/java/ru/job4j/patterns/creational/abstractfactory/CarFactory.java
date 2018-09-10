package ru.job4j.patterns.creational.abstractfactory;

import ru.job4j.patterns.creational.factory.Audi;
import ru.job4j.patterns.creational.factory.Car;
import ru.job4j.patterns.creational.factory.Toyota;

/**
 * Class CarFactory.
 */
public class CarFactory implements ru.job4j.patterns.creational.abstractfactory.Factory {
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

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}
