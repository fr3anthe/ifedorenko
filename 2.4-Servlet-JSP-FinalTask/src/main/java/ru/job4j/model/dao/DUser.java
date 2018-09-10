package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.MusicStyle;
import ru.job4j.model.entities.User;
import ru.job4j.model.repo.UserRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * DUser.
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DUser implements DAO<User>, UserRepo {
    private static final Logger LOGGER = LoggerFactory.getLogger(DUser.class);
    private static final DUser INSTANCE = new DUser();

    /**
     * Constructor.
     */
    private DUser() {
    }

    @Override
    public void add(final User user) {
        int id = 0;
        DAddress.getInstance().add(user.getAddress());
        int roleId = DRole.getInstance().findRoleIdByName(user.getRole().getName());
        String query = "insert into users(login, password, role_id, address_id) values (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, roleId);
            ps.setInt(4, user.getAddress().getId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    id = rs.getInt(1);
                    user.setId(id);
                }
            }
            if (id != 0 && user.getMusicStyles().size() > 0) {
                DUserMusic.getInstance().add(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(final User nUser) {
        User old = this.getById(nUser.getId());
        if (!old.getAddress().getName().equals(nUser.getAddress().getName())) {
            nUser.getAddress().setId(old.getAddress().getId());
            DAddress.getInstance().update(nUser.getAddress());
        }
        int roleId = DRole.getInstance().findRoleIdByName(nUser.getRole().getName());
        String query = "update users set password = ?, role = ?, address = ? where id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(2, nUser.getPassword());
            ps.setInt(3, roleId);
            ps.setInt(4, nUser.getAddress().getId());
            ps.executeUpdate();

            if (nUser.getMusicStyles().size() > 0) {
                DUserMusic userMusic = DUserMusic.getInstance();
                userMusic.delete(nUser.getId());
                userMusic.add(nUser);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }

}

    @Override
    public void delete(final int id) {
        String query = "delete from users where id = ?";
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public User getById(final int id) {
        String query = "select * from users where id = ?";
        User temp = null;
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    temp = new User.Builder(rs.getString("login"))
                            .id(rs.getInt("id"))
                            .password(rs.getString("password"))
                            .role(DRole.getInstance().getById(rs.getInt("role_id")))
                            .address(DAddress.getInstance().getById(rs.getInt("address_id")))
                            .music(this.getMusicStyles(rs.getInt("id")))
                            .build();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return temp;
        }
    }

    @Override
    public List<User> getAll() {
        String query = "select * from users";
        return findAllUsers(query);
    }

    @Override
    public List<User> findByRole(final String role) {
        String query = "select * from users where role_id = (select id from roles where name = " + role + ");";
        return findAllUsers(query);
    }

    @Override
    public List<User> findByAddress(final String address) {
        String query = "select * from users where address_id = (select id from addresses where name = " + address + ");";
        return findAllUsers(query);
    }

    @Override
    public List<User> findByMusicType(final String musicType) {
        String query = "select * from users where id in (select user_id from user_music where music_id = (select id from music_types where name = " + musicType + "))";
        return findAllUsers(query);
    }

    /**
     * Method getMusicTypes.
     * @param id id
     * @return list
     */
    private List<MusicStyle> getMusicStyles(final int id) {
        List<MusicStyle> list = new LinkedList<>();
        String query = "select music_id as id from user_music where user_id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        MusicStyle ms = DMusicStyle.getInstance().getById(rs.getInt("id"));
                        list.add(ms);
                    }
                }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return list;
        }
    }

    /**
     * Method findAllUsers.
     * @param query query
     * @return user' list
     */
    private List<User> findAllUsers(String query) {
        List<User> list = new LinkedList<>();
        try (Connection connect = DBConnection.getInstance().getConnection();
             PreparedStatement ps = connect.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                  list.add(new User.Builder(rs.getString("login"))
                            .id(rs.getInt("id"))
                            .password(rs.getString("password"))
                            .role(DRole.getInstance().getById(rs.getInt("role_id")))
                            .address(DAddress.getInstance().getById(rs.getInt("address_id")))
                            .music(this.getMusicStyles(rs.getInt("id")))
                            .build());
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            return list;
        }
    }

    /**
     * Method isCredential. If user exist, then return it.
     * @param login login for check.
     * @param password password for check.
     * @return user.
     */
    public User isCredential(String login, String password) {
        User temp = null;
        for (User user : this.getAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                temp = user;
                break;
            }
        }
        return temp;
    }

    /**
     * Getter for INSTANCE.
     * @return DUser instance
     */
    public static DUser getInstance() {
        return INSTANCE;
    }
}