package ru.job4j.patterns.other.dao;


/**
 * FileSystem
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class FileSystem implements Data {
    /**
     * method getFromFs.
     * @return data
     */
    String getFromFs() {
        return "data from fs";
    }

    @Override
    public String getData() {
        return this.getFromFs();
    }
}
