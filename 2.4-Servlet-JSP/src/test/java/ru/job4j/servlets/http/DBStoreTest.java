package ru.job4j.servlets.http;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


@PrepareForTest(ValidateService.class)
@RunWith(PowerMockRunner.class)
public class DBStoreTest {
    private DBStore store = mock(DBStore.class);
    private HelpForTesting hft;

    /**
     * Before.
     */
    @Before
    public void before() {
        Whitebox.setInternalState(DBStore.class, "INSTANCE", store);
        hft = new HelpForTesting();
    }

    /**
     * Test add.
     */
    @Test
    public void testAdd() {
        User user = new User("1", "test1", "", "", "", "", "");
        hft.add(user);
        verify(store, atLeastOnce()).add(user);

        hft.add(user);
        verify(store, times(2)).add(user);
    }

    /**
     * Test update
     */
    @Test
    public void testUpdate() {
        hft.update(null, null, null, null, null, null, null);
        verify(store, atLeastOnce()).update(null, null, null, null, null, null, null);
    }

    /**
     * Test Delete.
     */
    @Test
    public void testDelete() {
        hft.delete("test1");
        verify(store, atLeastOnce()).delete("test1");

        hft.delete("test1");
        verify(store, times(2)).delete("test1");
    }

    /**
     * Class for current test.
     */
    private class HelpForTesting {
        private DBStore store = DBStore.getInstance();

        /**
         * add.
         * @param user user
         */
        private void add(User user) {
            store.add(user);
        }

        /**
         * Update.
         * @param login login
         * @param name name
         * @param email email
         * @param role role
         * @param password password
         * @param country country
         * @param city city
         */
        private void update(String login, String name, String email, String role, String password, String country, String city) {
            store.update(login, name, email, role, password, country, city);
        }

        /**
         * Delete.
         * @param login login
         */
        private void delete(String login) {
            store.delete(login);
        }

        /**
         * Find.
         * @param login login
         * @return user
         */
        private User findById(String login) {
            return store.findByLogin(login);
        }
    }
}