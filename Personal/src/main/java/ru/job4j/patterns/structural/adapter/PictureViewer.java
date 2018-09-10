package ru.job4j.patterns.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class PictureViewer
 */
public class PictureViewer implements ImageViewer {
    @Override
    public void watchImage(String title, String format) {
        switch (format) {
            case (".png"):
                System.out.println("Watching " + title + ".png");
                break;
            case (".jpeg"):
                System.out.println("Watching " + title + ".jpg");
                break;
            case (".bmp"):
                System.out.println("Watching " + title + ".bmp");
                break;
            case (".gif"):
                ImageAdapter imageAdapter = new ImageAdapter(format);
                imageAdapter.watchImage(title, format);
                break;
            default:
                System.out.println("Watching " + title + ".not supported");
                break;
        }
    }
}
