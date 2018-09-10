package ru.job4j.patterns.creational.factorymethod;

/**
 * FactoryMethodPattern
 *
 * @author ifedorenko
 * @since 30.08.2018
 */
public class FactoryMethodPattern {
    /**
     * Method main.
     * @param args args.
     */
    public static void main(String[] args) {
        Creator spaceX = new SpaceX();
        spaceX.manage().make();

        Creator tesla = new Tesla();
        tesla.manage().make();
    }
}


