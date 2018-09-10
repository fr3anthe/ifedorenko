package ru.job4j.patterns.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Account
 * Вариант №2. Non classic.
 */
public class Account {
    private String login;
    private String password;
    private String email;

    /**
     * Constructor
     */
    private Account() {

    };

    @Override
    public String toString() {
        return "Account{"
                + "login='" + login + '\''
                + ", password='" + password + '\''
                + ", email='" + email + '\''
                + '}';
    }

    /**
     * Method initializeRegistration.
     * @return registrar
     */
    public static Registrar initializeRegistration() {
        return new Account().new Registrar();
    }

    /**
     * Class Registrar.
     */
    public class Registrar {
        /**
         * Constructor.
         */
        private Registrar() {

        };

        /**
         * Method login.
         * @param login login
         * @return this
         */
        public Registrar login(String login) {
            Account.this.login = login;
            return this;
        }
        /**
         * Method password.
         * @param password password
         * @return this.
         */
        public Registrar password(String password) {
            Account.this.password = password;
            return this;
        }
        /**
         * Method email.
         * @param email email
         * @return this.
         */
        public Registrar email(String email) {
            Account.this.email = email;
            return this;
        }

        /**
         * Method createAccount.
         * @return Account
         */
        public Account createAccount() {
            return Account.this;
        }
    }
}
