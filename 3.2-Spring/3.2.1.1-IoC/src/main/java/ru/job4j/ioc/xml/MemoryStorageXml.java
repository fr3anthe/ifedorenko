package ru.job4j.ioc.xml;

import ru.job4j.Storage;
import ru.job4j.User;

/**
 * class MemoryStorageXml.
 *
 * @author ifedorenko
 * @since 19.03.2019
 */
public class MemoryStorageXml implements Storage {
    private static final String MESSAGE = "xml";

    @Override
    public String add(User user) {
        return MESSAGE;
    }
}
