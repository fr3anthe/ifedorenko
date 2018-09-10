package ru.job4j.model.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBConnection
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DBConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBConnection.class);
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBConnection INSTANCE = new DBConnection();
    private final Properties properties;
    private final String config = "musicPlatform.properties";
    private final String driver = "org.postgresql.Driver";
    private final String url = "db.host";
    private final String username = "db.login";
    private final String password = "db.password";

    /**
     * Constructor.
     */
    private DBConnection() {
        this.properties = this.initProperties();
        SOURCE.setDriverClassName(driver);
        SOURCE.setUrl(properties.getProperty(url));
        SOURCE.setUsername(properties.getProperty(username));
        SOURCE.setPassword(properties.getProperty(password));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    /**
     * Method for initializing properties.
     * @return properties
     */
    private Properties initProperties() {
        Properties temp = new Properties();
        File file = new File(this.getClass().getClassLoader().getResource(config).getFile());
        try (FileInputStream fis = new FileInputStream(file)) {
            temp.load(fis);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return temp;
    }

    /**
     * Method getConnection.
     * @return connection
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = SOURCE.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return connection;
        }
    }

    /**
     * Getter for INSTANCE.
     * @return DBConnection instance
     */
    public static DBConnection getInstance() {
        return INSTANCE;
    }
}
