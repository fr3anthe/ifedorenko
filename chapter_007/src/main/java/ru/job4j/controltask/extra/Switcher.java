package ru.job4j.controltask.extra;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Switcher {
    @GuardedBy("this")
    private final StringBuilder sb;

    /**
     * Constructor.
     */
    public Switcher() {
        sb = new StringBuilder("");
    }

    /**
     * Method add.
     * @param value value for adding
     */
    public synchronized void add(int value) {
          sb.append(value);
    }

    /**
     * Method getStr.
     * @return string
     */
    public synchronized String getStr() {
        return sb.toString();
    }

    /**
     * Method length.
     * @return string length
     */
    public synchronized int length() {
        return sb.length();
    }
}

