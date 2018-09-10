package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * DRole.
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DRole implements DAO<Role> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DRole.class);
    private final String tableName = "roles";
    /**
     * @param INSTANCE instance
     */
    private static final DRole INSTANCE = new DRole();

    /**
     * Constructor.
     */
    private DRole() {
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DRole getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(final Role role) {
        String query = "insert into " + tableName + "(name) values (?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, role.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    role.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(final Role role) {
        String query = "update " + tableName + " set name = ? where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, role.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(final int id) {
        String query = "delete from " + tableName + " where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public Role getById(final int id) {
        String query = "select * from " + tableName + " where id = ?";
        Role result = null;
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Role(rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    @Override
    public List<Role> getAll() {
        String query =  "select * from " + tableName;
        List<Role> result = new LinkedList<>();
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Role(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    /**
     * Method findRoleIdByName.
     * @param name for finding
     * @return id
     */
    public int findRoleIdByName(final String name) {
        int id = 0;
        String query = "select * from roles where name = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return id;
        }
    }
}


