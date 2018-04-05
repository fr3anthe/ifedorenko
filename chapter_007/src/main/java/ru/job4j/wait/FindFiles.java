package ru.job4j.wait;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindFiles extends SimpleFileVisitor<Path> {

    private List<String> ext;
    private Queue<Path> files;

    /**
     * Constructor.
     * @param ext files extensions
     * @param files queue for adding files by extensions
     */
    public FindFiles(List<String> ext, Queue<Path> files) {
        this.ext = ext;
        this.files = files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (attr.isRegularFile()) {
            int temp = file.toString().lastIndexOf('.');
            if (ext.contains(file.toString().substring(temp + 1))) {
                files.add(file);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
