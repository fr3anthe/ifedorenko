package ru.job4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.model.entity.User;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ImportUserTest.
 */
public class ImportUserTest {
    /**
     * Test success №1.
     */
    @Test
    public void whenAddOneUserThenIdIs1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        ImportUser iu = context.getBean(ImportUser.class);
        User user = new User("Igor", "Fedorenko");
        int result = iu.addUser(user);
        assertThat(result, is(1));
    }

    /**
     * Test success №2.
     */
    @Test
    public void whenAddTwoUsersThenIdSecondUserIsTwo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        ImportUser iu = context.getBean(ImportUser.class);
        User user1 = new User("Igor", "Fedorenko");
        User user2 = new User("Petr", "Arsentiev");
        iu.addUser(user1);
        int result = iu.addUser(user2);
        assertThat(result, is(2));
    }

    /**
     * Test fail №1.
     */
    @Test
    public void whenAddUserIsNullThenReturnMinusOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test-context.xml");
        ImportUser iu = context.getBean(ImportUser.class);
        User user = null;
        int result = iu.addUser(user);
        assertThat(result, is(-1));
    }
}