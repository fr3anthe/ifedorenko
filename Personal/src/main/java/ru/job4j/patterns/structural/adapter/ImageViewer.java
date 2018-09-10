package ru.job4j.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface ImageViewer.
 */
public interface ImageViewer {
    /**
     * Method watchImage.
     * @param title title
     * @param format format
     */
    void watchImage(String title, String format);
}
