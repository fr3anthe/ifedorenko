package ru.job4j.ioc.annotation;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.User;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageAnnotationTest {
    private static ApplicationContext context;
    private static final String MESSAGE = "annotation";
    private static UserStorageAnnotation storage;

    /**
     * Method before class.
     */
    @BeforeClass
    public static void initContext() {
        context = new ClassPathXmlApplicationContext("spring-context-annotation.xml");
        storage = context.getBean(UserStorageAnnotation.class);
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