package ru.job4j.patterns.structural.bridge;

/**
 * Drawer.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
abstract class Drawer {
    protected Palette palette;

    /**
     * Constructor.
     * @param palette palletee
     */
    protected Drawer(Palette palette) {
        this.palette = palette;
    }

    /**
     * method drawShape.
     * @param color color.
     */
    public abstract void drawShape(String color);
}
