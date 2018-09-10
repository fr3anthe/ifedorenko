package ru.job4j.patterns.structural.bridge;

/**
 * Color.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class Color implements Palette {

    @Override
    public void setColor(String color) {
        System.out.println("Shape color: " + color);
    }
}
