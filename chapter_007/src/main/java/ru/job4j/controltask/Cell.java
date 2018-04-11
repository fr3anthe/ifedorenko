package ru.job4j.controltask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Cell.
 */
public class Cell extends ReentrantLock {
    /**
     * @param x position on the board by x
     */
    protected final int x;
    /**
     * @param y position on the board by y
     */
    protected final int y;

    /**
     * Constrcutor.
     * @param x position on the board by x
     * @param y position on the board by y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y.
     * @return y
     */
    public int getY() {
        return y;
    }
}
