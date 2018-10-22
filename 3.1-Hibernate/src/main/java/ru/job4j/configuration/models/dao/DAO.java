package ru.job4j.configuration.models.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface DAO.
 * @param <T> param
 */
public interface DAO<T extends Serializable> {
    /**
     * Add T in db.
     * @param t for adding;
     */
    void add(T t);

    /**
     * Update T in db.
     * @param t for updating
     */
    void update(T t);

    /**
     * Delete T from db.
     * @param id for deleting
     */
    void delete(int id);

    /**
     * Get T from bd by id.
     * @param id for finding
     * @return T
     */
    T getById(int id);

    /**
     * Get all T from DB.
     * @return list T
     */
    List<T> getAll();
}
