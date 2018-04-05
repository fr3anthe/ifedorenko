package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    private volatile boolean finish = false;

    @GuardedBy("this")
    private final Queue<Path> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    /**
     * Constructor.
     * @param root start folder for find
     * @param text text for seraching files
     * @param exts extensions by files
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * Method for starting search.
     * @throws InterruptedException exception
     */
    public void init() throws InterruptedException {
        Thread search = new Thread() {
            private FindFiles ff = new FindFiles(exts, files);
            private File file = new File(root);
            private Path path = file.toPath();

            @Override
            public void run() {
                try {
                    Files.walkFileTree(path, ff);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
            }
        };

        Thread read = new Thread() {

            @Override
            public void run() {
                while (!finish || !files.isEmpty()) {
                    if (files.size() > 0) {
                        try {
                            Path path = files.poll();
                            String temp = new String(Files.readAllBytes(path));
                            if (temp.contains(text)) {
                                paths.add(path.toString());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        search.start();
        read.start();
        search.join();
        read.join();
    }

    /**
     * Getter.
     * @return return list by paths
     */
    synchronized List<String>  result() {
        return this.paths;
    }
}

