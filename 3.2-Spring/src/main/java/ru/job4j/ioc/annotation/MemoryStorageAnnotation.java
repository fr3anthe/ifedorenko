package ru.job4j.ioc.annotation;

import org.springframework.stereotype.Component;
import ru.job4j.Storage;
import ru.job4j.User;

/**
 * class MemoryStorageAnnotation.
 *
 * @author ifedorenko
 * @since 19.03.2019
 */
@Component
public class MemoryStorageAnnotation implements Storage {
    private static final String MESSAGE = "annotation";

    @Override
    public String add(User user) {
        return MESSAGE;
    }
}
