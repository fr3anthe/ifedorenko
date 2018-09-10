package ru.job4j.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class GifViewer.
 */
public class GifViewer implements AnimatedImageViewer {

    @Override
    public void watchGif(String title) {
        System.out.println("Watching " + title + ".gif");
    }
}
