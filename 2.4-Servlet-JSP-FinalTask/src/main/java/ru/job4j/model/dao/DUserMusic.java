package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.MusicType;
import ru.job4j.model.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Class DUserMusic
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DUserMusic implements DAO<User> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DUserMusic.class);
    private static final DUserMusic INSTANCE = new DUserMusic();

    /**
     * Constructor.
     */
    private DUserMusic() {
    }

    @Override
    public void add(final User user) {
        String query = "insert into user_music(user_id, music_id) value (?, (select id from music_types where name = ?))";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            for (MusicType mt : user.getMusicTypes()) {
                ps.setInt(1, user.getId());
                ps.setString(2, mt.getName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(final int id) {
        String query = "delete from user_music where user_id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    /**
     * Getter for INSTANCE.
     * @return DUserMusic instance
     */
    public static DUserMusic getInstance() {
        return INSTANCE;
    }
}
