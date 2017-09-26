package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ArrayContainer.
 * @param <E> generic
 */
public class ArrayContainer<E> implements SimpleContainer<E> {
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
    public ArrayContainer(int initialCapacity) {
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
    public ArrayContainer() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Method add.
     * @param e object for adding
     */
    @Override
    public void add(E e) {
        if (index >= objects.length) {
            objects = Arrays.copyOf(objects, objects.length * 2);
            objects[index++] = e;
        } else {
            objects[index++] = e;
        }
    }

    /**
     * Method get.
     * @param index position for return.
     * @return object.
     */
    @Override
    public E get(int index) {
        E result = null;
        if (index >= objects.length) {
            throw new IndexOutOfBoundsException();
        } else {
            result = (E) objects[index];
        }
        return result;
    }

    /**
     * Iterator.
     * @return iterator
     */
    @Override
    public Iterator iterator() {
        Iterator<E> iterator = new Iterator<E>() {
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
        return iterator;
    }
}
