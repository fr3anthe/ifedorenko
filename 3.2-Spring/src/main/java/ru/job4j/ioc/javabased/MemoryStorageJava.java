package ru.job4j.ioc.javabased;

import org.springframework.stereotype.Component;
import ru.job4j.Storage;
import ru.job4j.User;

/**
 * class MemoryStorageJava.
 *
 * @author ifedorenko
 * @since 19.03.2019
 */
@Component
public class MemoryStorageJava implements Storage {
    private static final String MESSAGE = "java";

    @Override
    public String  add(User user) {
        return MESSAGE;
    }
}
