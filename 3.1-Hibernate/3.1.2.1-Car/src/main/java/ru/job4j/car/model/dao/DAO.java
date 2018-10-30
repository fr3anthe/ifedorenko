package ru.job4j.car.model.dao;

import ru.job4j.car.model.entities.Entity;

/**
 * Interface DAO.
 * @param <E> param
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
}
