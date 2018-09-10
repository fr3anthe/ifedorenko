package ru.job4j.patterns.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Car.
 * Вариант №1. Classic.
 */
public class SportCar {
    /**
     * Можно и не final. Для immutable.
     */
    private String name;
    private String color;
    private int maxSpeed;

    /**
     * Constructor.
     * @param builder builder
     */
    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", color=" + color + ", maxSpeed=" + maxSpeed + '}';
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for color.
     * @return color
     */
    public String getColor() {
        return color;
    }
    /**
     * Getter for maxSpeed.
     * @return maxSpeed
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Builder for Car.
     */
    static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

        /**
         * Constructor.
         * @param name name
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Setter for color.
         * @param color color
         * @return builder
         */
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        /**
         * Setter for maxSpeed.
         * @param maxSpeed max speed
         * @return builder
         */
        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        /**
         * Method build.
         * @return Car.
         */
        public SportCar build() {
            return new SportCar(this);
        }
    }
}
