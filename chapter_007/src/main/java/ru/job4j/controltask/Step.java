package ru.job4j.controltask;

import java.util.Random;

/**
 * Class Step.
 */
public class Step {
    /**
     * @param STEP_UP step up
     */
    private static final int[] STEP_UP = {-1, 0};
    /**
     * @param STEP_RIGHT step right
     */
    private static final int[] STEP_RIGHT = {0, 1};
    /**
     * @param STEP_DOWN step down
     */
    private static final int[] STEP_DOWN = {1, 0};
    /**
     * @param STEP_LEFT step left
     */
    private static final int[] STEP_LEFT = {0, -1};
    /**
     * @param All_STEP all possible steps
     */
    private static final int[][] ALL_STEP = {STEP_UP, STEP_RIGHT, STEP_DOWN, STEP_LEFT};

    /**
     * Method move.
     * Randomly select one step from all varinats.
     * @return array values for step
     */
    public int[] move() {
        int[] result = ALL_STEP[new Random().nextInt(4)];
        return result;
    }
}
