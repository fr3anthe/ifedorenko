package ru.job4j.patterns.creational.objectpool;

import java.util.LinkedList;
import java.util.List;

/**
 * ObjectPool.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class ObjectPool {
    /**
     * @param free free
     */
    private List<PooledObject> free = new LinkedList<>();
    /**
     * @param used used
     */
    private List<PooledObject> used = new LinkedList<>();

    /**
     * Method getPooledObject.
     * @return PooledObject
     */
    public PooledObject getPooledObject() {
        if (free.isEmpty()) {
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);
            return pooledObject;
        } else {
            PooledObject pooledObject = free.get(0);
            used.add(pooledObject);
            free.remove(pooledObject);
            return pooledObject;
        }
    }

    /**
     * Method releasePooledObject.
     * @param pooledObject poolObject
     */
    public void releasePooledObject(PooledObject pooledObject) {
        used.remove(pooledObject);
        free.add(pooledObject);
    }
}
