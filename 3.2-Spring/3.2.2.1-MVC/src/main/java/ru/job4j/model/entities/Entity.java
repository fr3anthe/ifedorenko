package ru.job4j.model.entities;

import java.io.Serializable;

/**
 * Interface Entity.
 */
public interface Entity extends Serializable {
    /**
     * getId.
     * @return entity's id
     */
    int getId();

    /**
     * setId.
     * @param id set id for entity.
     */
    void setId(int id);
}
