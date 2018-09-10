package ru.job4j.patterns.creational.abstractfactory;

import ru.job4j.patterns.creational.factory.Car;

/**
 * AbstractFactoryPattern.
 *
 * Фабрика фабрик. Фабрика, которая производит другие фабрики.
 *
 * @author ifedorenko
 * @since 30.08.2018
 */
public class AbstractFactoryPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        AbstractFactory af = new AbstractFactory();
        Factory carFactory = af.createFactory("Car");
        Factory tankFactory = af.createFactory("Tank");
        Car audi = carFactory.createCar("Audi");
        Tank t51 = tankFactory.createTank("T51");
        audi.drive();
        t51.drive();
    }
}


