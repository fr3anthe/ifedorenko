package ru.job4j.patterns.creational.prototype;

/**
 * ConcretePizza.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class ConcretePizza implements Pizza {

    private String size;
    private String sauce;
    private String cheese;
    private String mushrooms;
    private String sausages;

    /**
     * Setter for size.
     * @param size size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Setter for sauce.
     * @param sauce sauce
     */
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    /**
     * Setter for cheese.
     * @param cheese cheese
     */
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    /**
     * Setter for mushrooms.
     * @param mushrooms mushrooms
     */
    public void setMushrooms(String mushrooms) {
        this.mushrooms = mushrooms;
    }

    /**
     * Setter for sausages.
     * @param sausages sausages
     */
    public void setSausages(String sausages) {
        this.sausages = sausages;
    }

    @Override
    public Pizza make() throws CloneNotSupportedException {
        return (Pizza) super.clone();
    }

    @Override
    public String toString() {
        return "ConcretePizza{"
                + "size='" + size + '\''
                + ", sauce='" + sauce + '\''
                + ", chees='" + cheese + '\''
                + ", mushrooma='" + mushrooms + '\''
                + ", sausages='" + sausages + '\''
                + '}';
    }
}
