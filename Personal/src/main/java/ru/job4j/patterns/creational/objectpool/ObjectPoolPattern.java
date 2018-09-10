package ru.job4j.patterns.creational.objectpool;

/**
 * ObjectPoolPattern.
 *
 * набор инициализированных и готовых к использованию объектов.
 * Когда системе требуется объект, он не создаётся, а берётся из пула.
 * Когда объект больше не нужен, он не уничтожается, а возвращается в пул.
 *
 * улы объектов (известны также как пулы ресурсов) используются для управления
 * кэшированием объектов. Клиент, имеющий доступ к пулу объектов может избежать
 * создания новых объектов, просто запрашивая в пуле уже созданный экземпляр
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class ObjectPoolPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();
        PooledObject pooledObject = objectPool.getPooledObject();
        objectPool.releasePooledObject(pooledObject);
    }
}
