package ru.job4j.ioc.xml;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageXmlTest {
    private static ApplicationContext context;
    private static final String MESSAGE = "xml";
    private static UserStorageXml storage;

    /**
     * Method before class.
     */
    @BeforeClass
    public static void initContext() {
        context = new ClassPathXmlApplicationContext("spring-context-xml.xml");
        storage = context.getBean(UserStorageXml.class);
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