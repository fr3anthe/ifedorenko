package ru.job4j.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class ImageAdapter.
 */
public class ImageAdapter implements ImageViewer {
    private AnimatedImageViewer aiv;

    /**
     * Constructor.
     * @param format format
     */
    public ImageAdapter(String format) {
        if (format.equalsIgnoreCase(".gif")) {
            aiv = new GifViewer();
        }
    }

    @Override
    public void watchImage(String title, String format) {
        if (format.equalsIgnoreCase(".gif")) {
            aiv.watchGif(title);
        }
    }
}
