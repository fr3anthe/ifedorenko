package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArraySet.
 * @param <E>
 */
public class ArraySet<E> implements SimpleSet<E> {
    /**
     * @param DEFAULT_CAPACITY default size of array
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * @param EMPTY_ELEMENTDATA size array when initialize by null
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * @param objects our container
     */
    private Object[] objects;
    /**
     * @param index position in array
     */
    private int index = 0;

    /**
     * Constructor.
     * @param initialCapacity start size.
     */
    public ArraySet(int initialCapacity) {
        if (initialCapacity > 0) {
            this.objects = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.objects = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * Default constructor.
     */
    public ArraySet() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Method add.
     * @param e element for adding.
     */
    @Override
    public void add(E e) {
        if (checkDuplicate(e)) {
            if (index >= objects.length) {
                objects = Arrays.copyOf(objects, objects.length * 2);
                objects[index++] = e;
            } else {
                objects[index++] = e;
            }
        }
    }

    /**
     * Method checkDuplicate.
     * @param e element for checking.
     * @return result
     */
    public boolean checkDuplicate(E e) {
        boolean result = true;
        for (Object ob : objects) {
            if (e == ob) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Iterator.
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> result = new Iterator<E>() {
            /**
             * @param position position in array
             */
            private int position = 0;

            /**
             * Method hasNext.
             * @return result
             */
            @Override
            public boolean hasNext() {
                return position < index;
            }

            /**
             * Method next.
             * @return object
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) objects[position++];
            }
        };
        return result;
    }

    /**
     * Getter index.
     * @return index
     */
    public int getIndex() {
        return index;
    }
}
