package ru.job4j.ioc.javabased;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.User;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageJavaTest {
    private static AnnotationConfigApplicationContext context;
    private static final String MESSAGE = "java";
    private static UserStorageJava storage;

    /**
     * Method before class.
     */
    @BeforeClass
    public static void initContext() {
        context = new AnnotationConfigApplicationContext(SpringBeans.class);
        storage = context.getBean(UserStorageJava.class);
    }

    /**
     * Method whenLoadContextShouldGetBeans.
     */
    @Test
    public void whenLoadContextShouldGetBeans()  {
        assertNotNull(storage);
    }

    /**
     * Method whenAddUserToStorageShouldReturnMessage
     */
    @Test
    public void whenAddUserToStorageShouldReturnMessage()  {
        String expect = storage.add(new User());
        assertThat(MESSAGE, is(expect));
    }
}