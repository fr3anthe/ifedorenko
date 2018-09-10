package ru.job4j.patterns.creational.factory;

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

}
