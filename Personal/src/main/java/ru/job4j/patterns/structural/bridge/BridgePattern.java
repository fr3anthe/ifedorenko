package ru.job4j.patterns.structural.bridge;

/**
 * Bridge.
 *
 * Это структурный паттерн проектирования,
 * который разделяет один или несколько классов на две отдельные иерархии —
 * абстракцию и реализацию, позволяя изменять их независимо друг от друга.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class  BridgePattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        Drawer drawer = new Square(new Color());
        drawer.drawShape("#00FF00");
    }
}

