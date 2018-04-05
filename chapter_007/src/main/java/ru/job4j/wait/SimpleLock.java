package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SimpleLock {

    @GuardedBy("this")
    private boolean lockState = false;
    private Thread lockedBy = null;
    private int count = 0;

    /**
     * Method lock.
     * @throws InterruptedException exception
     */
    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (lockState && lockedBy != callingThread) {
            wait();
        }
        lockState = true;
        lockedBy = callingThread;
        count++;

    }

    /**
     * Method unlock.
     */
    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            count--;
            if (count == 0) {
                lockState = false;
                notify();

            }
        }
    }

    /**
     * Getter LockState.
     * @return result
     */
    public boolean getLockState() {
        return lockState;
    }
}
