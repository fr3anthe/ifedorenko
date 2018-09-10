package ru.job4j.patterns.creational.factory;

/**
 * FactoryPattern
 *
 * Factory - порождающий шаблон проектирования,
 * предоставляющий подклассам интерфейс для создания экземпляров некоторого класса.
 * Основываясь на вводных данных, создает необходимый объект.
 *
 * @author ifedorenko
 * @since 30.08.2018
 */
public class FactoryPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car toyota = factory.createCar("Toyota");
        Car audi = factory.createCar("Audi");
        toyota.drive();
        audi.drive();
    }
}

