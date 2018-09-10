package ru.job4j.patterns.structural.bridge;

/**
 * Square.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class Square extends Drawer {
    /**
     * Constructor.
     * @param palette palette
     */
    protected Square(Palette palette) {
        super(palette);
    }

    @Override
    public void drawShape(String color) {
        switch (color) {
            case ("#FF0000"): palette.setColor("Red"); break;
            case ("#00FF00"): palette.setColor("Green"); break;
            case ("#0000FF"): palette.setColor("Blue"); break;
            default: System.out.println("Undefined color");
        }
    }
}
