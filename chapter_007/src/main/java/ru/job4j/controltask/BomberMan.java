package ru.job4j.controltask;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Class Bomberman.
 */
public class BomberMan implements Runnable {
    /**
     * @param board our game board
     */
    private final Board board;
    /**
     * @param step step for movement
     */
    private final Step step;
    /**
     * @param currentCell current position on the board
     */
    private Cell currentCell;
    /**
     * @param stop stop move
     */
    private volatile boolean stop = false;

    /**
     * Constructor.
     * The position for the starting position of the Bomberman is selected randomly.
     * @param board our game board
     */
    public BomberMan(Board board) {
        this.board = board;
        step = new Step();
        currentCell = (Cell) board.getBoard()[new Random().nextInt(board.getMaxX())][new Random().nextInt(board.getMaxY())];
    }

    /**
     * Method run.
     */
    public void run() {
        currentCell.lock();
        int[] steps = step.move();
        while (!stop) {
            int moveX = currentCell.x + steps[0];
            int moveY = currentCell.y + steps[1];
            if (moveX < board.getMaxX() && moveX >= board.getMinX() && moveY < board.getMaxY() && moveY >= board.getMinY()) {
                Cell newCell = (Cell) board.getBoard()[moveX][moveY];
                try {
                    if (newCell.tryLock(500, TimeUnit.MILLISECONDS)) {
                        currentCell.unlock();
                        currentCell = newCell;
                        System.out.println(currentCell.x + " " + currentCell.y);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            steps = step.move();
        }
        System.out.println("Move is stoped.");
        System.out.println("Current position by X: " + currentCell.x);
        System.out.println("Current position by Y: " + currentCell.y);
    }
}
