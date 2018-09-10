package ru.job4j.model.dao;

import ru.job4j.model.entities.BaseEntity;
import ru.job4j.model.entities.Entity;

import java.util.List;

/**
 * Interface DAO.
 * @param <T> extends BaseEntity
 */
public interface DAO<T extends Entity> {

    /**
     * Method add in db.
     * @param t for adding
     */
    void add(T t);

    /**
     * Method update in db.
     * @param t for updating
     */
    void update(T t);

    /**
     * MEthod delete from db.
     * @param id for deleting
     */
    void delete(int id);

    /**
     * Merthod getById.
     * @param id for getting
     * @return T
     */
    T getById(int id);

    /**
     * Method getALl.
     * @return List
     */
    List<T> getAll();
}
