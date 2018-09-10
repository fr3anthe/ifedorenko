package ru.job4j.patterns.other.dao;
/**
 * Db
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class Db implements Data {
    /**
     * method getFromTable.
     * @return data
     */
    String getFromTable() {
        return "data from table";
    }

    @Override
    public String getData() {
        return this.getFromTable();
    }
}
