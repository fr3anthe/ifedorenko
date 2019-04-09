package ru.job4j.model.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * class Database
 *
 * @author ifedorenko
 * @since 09.04.2019
 */

public class Database {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
    private Connection connection;
    private String login;
    private String password;
    private String table;
    private String host;


    /**
     * Method for connecting to database.
     */
    public void connectDB() {
        try {
            connection = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            LOGGER.info("Wrong data for connect");
        }
    }

    /**
     * Method closeConnection
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
