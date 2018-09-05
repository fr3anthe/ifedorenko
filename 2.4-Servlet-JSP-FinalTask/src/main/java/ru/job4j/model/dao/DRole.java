package ru.job4j.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.database.DBConnection;
import ru.job4j.model.entities.Role;
import ru.job4j.model.entities.User;
import ru.job4j.model.repo.RoleRepo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * DRole.
 *
 * @author ifedorenko
 * @since 05.09.2018
 */
public class DRole extends AbstractDAO<Role> implements RoleRepo {
    /**
     * @param INSTANCE instance
     */
    private static final DRole INSTANCE = new DRole("roles", LoggerFactory.getLogger(DRole.class));

    /**
     * Constructor.
     * @param table table name
     * @param logger logger
     */
    private DRole(String table, Logger logger) {
        super(table, logger);
    }

    /**
     * Getter for INSTANCE.
     * @return DRole instance
     */
    public static DRole getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> findByRole(final String role) {
        return DUser.getInstance().findByRole(role);
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
            logger.error(e.getMessage(), e);
        } finally {
            return id;
        }
    }
}


