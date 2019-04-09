package ru.job4j.model.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcStorage implements UserStorage {
    private Database database;
    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcStorage.class);

    /**
     * Constructor.
     * @param database database
     */
    public JdbcStorage(Database database) {
        this.database = database;

    }

    @Override
    public int addUser(User user) {
        int result = -1;
        String addQuery = "insert into " + database.getTable() + " (name, surname) values (?,?)";
        try (PreparedStatement ps = this.database.getConnection().prepareStatement(addQuery, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }
}
