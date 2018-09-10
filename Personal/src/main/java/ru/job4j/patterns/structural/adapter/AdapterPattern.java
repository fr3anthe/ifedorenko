package ru.job4j.patterns.structural.adapter;

/**
 * Adapter
 *
 * Позволяет обеспечить взаимодействие объектов с разными интерфейсами.
 * Т.е. с его помощью мы можем использовтаь разные функции, при этом имея неподходящий интерфейс
 * для реализации этих функций.
 *
 * Существует две реализации данного шаблона.
 * Объектный адаптер - решает вопрос с помощью композиции.
 * Классовый адаптер - решает вопрос с помощью множественного наследования.
 * @author ifedorenko
 * @since 30.08.2018
 */
public class AdapterPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        PictureViewer pv = new PictureViewer();
        pv.watchImage("space", ".png");
        pv.watchImage("admin", "jpeg");
        pv.watchImage("square", ".bmp");
        pv.watchImage("animation", ".gif");
        pv.watchImage("image", ".jpg");

    }
}

