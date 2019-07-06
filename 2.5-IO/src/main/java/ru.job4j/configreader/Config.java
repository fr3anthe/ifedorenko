package ru.job4j.configreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * Classs for reading config file.
 */
public class Config {
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    /**
     * Constructor.
     * @param path path to config file
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Method for load config file.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(l -> l.contains("="))
                    .forEach(l -> this.values.put(l.substring(0, l.indexOf("=")), l.substring(l.indexOf("=") + 1)));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Mmethod for read config file.
     * @param key for value
     * @return value
     */
    public String value(String key) {
        String result = this.values.get(key);
        if (result == null) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}