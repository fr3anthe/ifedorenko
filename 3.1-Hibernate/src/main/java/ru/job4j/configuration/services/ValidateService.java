package ru.job4j.configuration.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.configuration.models.dao.DItem;
import ru.job4j.configuration.models.entities.Item;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ValidateService.
 *
 * @author ifedorenko
 * @since 16.10.2018
 */
public class ValidateService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateService.class);
    /**
     * Singleton variable
     */
    private static final ValidateService INSTANCE = new ValidateService();
    /**
     * Store
     */
    private final DItem store = DItem.getInstance();
    private final Boolean basicStatus = false;

    /**
     * Private cosntructor for Singleton
     */
    private ValidateService() {
    }

    /**
     * Add item in db.
     * @param item for adding;
     */
    public void add(Item item) {
        item.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        item.setDone(basicStatus);
        store.add(item);
    }

    /**
     * Update item in db.
     * @param item for updating
     */
    public void update(Item item) {
        store.update(item);
    }

    /**
     * Delete item from db.
     * @param id for deleting
     */
    public void delete(int id) {
        store.delete(id);
    }

    /**
     * Get item from bd by id.
     * @param id for finding
     * @return item
     */
    public Item getById(int id) {
       return store.getById(id);
    }

    /**
     * Get all items from DB.
     * @return list item
     */
    public List<Item> getAll() {
        return store.getAll();
    }

    /**
     * Get ValidateService.
     * @return ValidateService instance.
     */
    public static ValidateService getInstance() {
        return INSTANCE;
    }
}

