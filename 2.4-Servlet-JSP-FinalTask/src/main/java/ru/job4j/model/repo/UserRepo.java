package ru.job4j.model.repo;

import ru.job4j.model.entities.User;
import java.util.List;

/**
 * Interface UserRepo.
 */
public interface UserRepo {
    /**
     * Method findByAddress.
     * @param address for finding.
     * @return user's list
     */
    List<User> findByAddress(String address);
    /**
     * Method findByMusicType.
     * @param musicType for finding.
     * @return user's list
     */
    List<User> findByMusicType(String musicType);
    /**
     * Method findByRole
     * @param role for finding.
     * @return user's list
     */
    List<User> findByRole(String role);
}
