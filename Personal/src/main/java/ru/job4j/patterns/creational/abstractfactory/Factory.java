package ru.job4j.patterns.creational.abstractfactory;

import ru.job4j.patterns.creational.factory.Car;

/**
 * Interface Factory.
 */
public interface Factory {
    /**
     * Method createCar.
     * @param typeOfCar car's model
     * @return car's object
     */
    Car createCar(String typeOfCar);

    /**
     * Method createTank.
     * @param typeOfTank tank's model
     * @return tank's object
     */
    Tank createTank(String typeOfTank);
}
