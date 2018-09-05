package ru.job4j.model.repo;

import ru.job4j.model.entities.User;
import java.util.List;

/**
 * Interface RokeRepo
 */
public interface RoleRepo {
    /**
     * Method findByRole
     * @param role for finding.
     * @return user's list
     */
    List<User> findByRole(String role);
}
