package ru.job4j.model.dao;

import org.slf4j.Logger;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.BaseEntity;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * AbstractDAO
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public abstract class AbstractDAO<T extends BaseEntity> implements DAO<T> {
    private final String table;
    protected final Logger logger;

    /**
     * Constructor.
     * @param table table name
     * @param logger logger
     */
    public AbstractDAO(String table, Logger logger) {
        this.table = table;
        this.logger = logger;
    }

    @Override
    public void add(final T t) {
        String query = "insert into " + table + "(name) values (?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, t.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    t.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
    @Override
    public void update(final T t) {
        String query = "update " + table + " set name = ? where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, t.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
    @Override
    public void delete(final int id) {
        String query = "delete from " + table + " where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
    @Override
    public T getById(final int id) {
        String query = "select * from " + table + " where id = ?";
        T temp = null;
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    temp = (T) new BaseEntity(rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            return temp;
        }
    }
    @Override
    public List<T> getAll() {
        String query =  "select * from " + table;
        List<T> list = new LinkedList<>();
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add((T) new BaseEntity(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            return list;
        }
    }
}
