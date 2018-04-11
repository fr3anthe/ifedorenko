package ru.job4j.controltask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Board.
 */
public class Board {
    /**
     * @param board game board
     */
    private final ReentrantLock[][] board;
    /**
     * @param maxX max value by X for our board
     */
    private final int maxX;
    /**
     * @param MaxY max value by Y for our board
     */
    private final int maxY;
    /**
     * @param minX min value by X for our board
     */
    private final int minX = 0;
    /**
     * @param minY min value by Y for our board
     */
    private final int minY = 0;

    /**
     * Constrcutor
     * @param x count of rows
     * @param y count of column
     */
    public Board(int x, int y) {
        this.board = new ReentrantLock[x][y];
        maxX = board.length;
        maxY = board[0].length;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                this.board[i][j] = new Cell(i, j);
            }
        }

    }

    /**
     * Getter for board.
     * @return board
     */
    public ReentrantLock[][] getBoard() {
        return board;
    }

    /**
     * Getter for MaxX.
     * @return MaxX
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Getter for MaxY.
     * @return MaxY
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Getter for MinX.
     * @return MinX
     */
    public int getMinX() {
        return minX;
    }

    /**
     * Getter for MinY.
     * @return minY
     */
    public int getMinY() {
        return minY;
    }
}
