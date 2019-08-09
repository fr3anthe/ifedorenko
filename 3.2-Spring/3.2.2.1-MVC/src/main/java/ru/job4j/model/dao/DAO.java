package ru.job4j.model.dao;

import ru.job4j.model.entities.Entity;
import java.util.List;

/**
 * Interface DAO.
 * @param <E> e
 */
public interface DAO<E extends Entity> {
    /**
     * Add E in db.
     * @param add object for adding;
     * @return id or -1 if error
     */
    int add(E add);

    /**
     * Update E in db.
     * @param update object for updating
     * @return id or -1 if error
     */
    int update(E update);

    /**
     * Delete T from db.
     * @param delete object for deleting
     * @return id or -1 if error
     */
    int delete(E delete);

    /**
     * Get E from bd by id.
     * @param id for finding
     * @return E
     */
    E getById(int id);

    /**
     * Get all E from DB.
     * @return list E
     */
    List<E> getAll();
}
