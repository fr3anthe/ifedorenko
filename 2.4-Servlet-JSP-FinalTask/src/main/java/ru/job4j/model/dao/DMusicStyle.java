package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.MusicStyle;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * DMusicType
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DMusicStyle implements DAO<MusicStyle> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DMusicStyle.class);
    private final String tableName = "music_styles";
    /**
     * @param INSTANCE instance
     */
    private static final DMusicStyle INSTANCE = new DMusicStyle();

    /**
     * Constructor.
     */
    private DMusicStyle() {
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DMusicStyle getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(final MusicStyle music) {
        String query = "insert into " + tableName + "(name) values (?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, music.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    music.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(final MusicStyle music) {
        String query = "update " + tableName + " set name = ? where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setString(1, music.getName());
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
    public MusicStyle getById(final int id) {
        String query = "select * from " + tableName + " where id = ?";
        MusicStyle result = null;
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new MusicStyle(rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }

    @Override
    public List<MusicStyle> getAll() {
        String query =  "select * from " + tableName;
        List<MusicStyle> result = new LinkedList<>();
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new MusicStyle(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return result;
        }
    }
}