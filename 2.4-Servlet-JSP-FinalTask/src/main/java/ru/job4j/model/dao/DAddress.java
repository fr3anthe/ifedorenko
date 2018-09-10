package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.Address;
import ru.job4j.model.entities.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * DAddress.
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DAddress implements DAO<Address> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DAddress.class);
    private final String tableName = "addresses";
    /**
     * @param INSTANCE instance
     */
    private static final DAddress INSTANCE = new DAddress();

    /**
     * Constructor.
     */
    private DAddress() {
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DAddress getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(final Address address) {
        String query = "insert into " + tableName + "(name) values (?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, address.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    address.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(final Address address) {
        String query = "update " + tableName + " set name = ? where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, address.getName());
            ps.setInt(2, address.getId());
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
    public Address getById(final int id) {
        String query = "select * from " + tableName + " where id = ?";
        Address result = null;
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Address(rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    @Override
    public List<Address> getAll() {
        String query =  "select * from " + tableName;
        List<Address> result = new LinkedList<>();
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Address(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }
}
