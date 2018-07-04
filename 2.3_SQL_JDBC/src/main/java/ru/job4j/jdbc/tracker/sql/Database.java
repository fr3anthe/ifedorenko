package ru.job4j.jdbc.tracker.sql;

import ru.job4j.jdbc.tracker.Item;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Class Database.
 */
public class Database implements AutoCloseable {
    /**
     * @param connection connection
     */
    private Connection connection;
    /**
     * @param propetries properties
     */
    private Properties properties;

    /**
     * Constrcutor.
     * @throws IOException exception
     * @throws SQLException exception
     */
    public Database() throws IOException, SQLException {
        connection = null;
        properties = new Properties();
        initProperties();
        initDB();
    }

    /**
     * Method for initializing properties.
     * @throws IOException exception
     */
    public void initProperties() throws IOException {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        }
    }

    /**
     * Method for initializing work with database.
     * @throws SQLException exception
     * @throws IOException exception
     */
    public void initDB() throws SQLException, IOException {
        if (!connectDB()) {
            createDB();
            connectDB();
            createTable();
        }
    }

    /**
     * Method for connecting to database.
     * @return result
     */
    public boolean connectDB() {
        boolean result = false;
        String host = properties.getProperty("db.host");
        String login = properties.getProperty("db.login");
        String password = properties.getProperty("db.password");

        try {
            connection = DriverManager.getConnection(host, login, password);
            if (connection != null) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * Method for creating database.
     * @throws SQLException exception
     */
    private void createDB() throws SQLException {
        String host = properties.getProperty("db.postgres");
        String login = properties.getProperty("db.login");
        String password = properties.getProperty("db.password");

        try (Connection conn = DriverManager.getConnection(host, login, password)) {
            if (conn != null) {
                conn.prepareStatement(properties.getProperty("createDB")).execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for create table.
     */
    private void createTable() {
        try {
            connection.prepareStatement(properties.getProperty("createTable")).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add in database.
     * @param item item item for adding
     */
    public void add(Item item) {
        try (PreparedStatement ps = connection.prepareStatement("insert into items(name, description, create_date) values (?, ?, ?)")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setTimestamp(3, new Timestamp(item.getCreate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        item.setId(takeId());
    }

    /**
     * update in database.
     * @param item item for update
     */
    public void update(Item item) {
        int id = item.getId();
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("update"))) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setTimestamp(3, new Timestamp(item.getCreate()));
            ps.setInt(4, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for deleting from databse.
     * @param item item for delete
     */
    public void delete(Item item) {
        int id = item.getId();
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("delete"))) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for finding all in database.
     */
    public void findAll() {
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("findAll"))) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(String.format("%d %s %s ", rs.getInt("id"), rs.getString("name"), rs.getString("description")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for find by name.
     * @param name name for find
     */
    public void findByName(String name) {
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("findByName"))) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(String.format("%d %s %s ", rs.getInt("id"), rs.getString("name"), rs.getString("description")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for find by id.
     * @param id id for find
     * @return result
     */
    public String findById(int id) {
        String result = null;
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("findById"))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(String.format("%d %s %s ", rs.getInt("id"), rs.getString("name"), rs.getString("description")));
                    result = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method size.
     * @return current size a database
     */
    public int size() {
        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement(properties.getProperty("size"))) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method for take id.
     * @return id
     */
    private int takeId() {
        int result = 0;
        try (PreparedStatement ps = connection.prepareStatement("select MAX(id) from items")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method close.
     * @throws Exception exception
     */
    @Override
    public void close() throws Exception {
        connection.close();
    }
}
