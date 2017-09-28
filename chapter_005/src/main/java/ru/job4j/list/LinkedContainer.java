package ru.job4j.list;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedContainer.
 * @param <E> generic
 */
public class LinkedContainer<E> implements SimpleContainer<E> {
    /**
     * @param size size of container
     */
    private int size = 0;
    /**
     * @param first first element in container
     */
    private Link<E> first;
    /**
     * @param last last element in container
     */
    private Link<E> last;

    /**
     * Method add.
     * @param e element for adding
     */
    @Override
    public void add(E e) {
        if (size > 0) {
            Link<E> newLink = new Link<>(last, e, null);
            last.next = newLink;
            last = newLink;
            size++;
        } else {
            first = new Link<>(null, e, null);
            last = first;
            size++;
        }
    }

    /**
     * Method get.
     * @param index position in container.
     * @return object
     */
    @Override
    public E get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
        Link<E> temp;
        E result;
        if (index < (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            result = temp.item;
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = last.prev;
            }
            result = temp.item;
        }
        return result;
    }

    /**
     * Method get.
     * @param link link
     * @return item.
     */
    public E get(Link<E> link) {
        E result = link.item;
        return result;
    }

    /**
     * Iterator.
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private Link<E> temp = first;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = temp.item;
                temp = temp.next;
                return result;
            }
        };
        return iterator;
    }

    /**
     * Method delete first link.
     */
    public void deleteFirst() {
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
            size--;
        }
    }

    /**
     * Method delete last link.
     */
    public void deleteLast() {
        if (last == first) {
            last = null;
            first = null;
        } else {
            last = last.prev;
            last.next = null;
            size--;
        }
    }

    /**
     * Getter First.
     * @return First link
     */
    public Link<E> getFirst() {
        return first;
    }

    /**
     * Getter Last.
     * @return Last link
     */
    public Link<E> getLast() {
        return last;
    }

    /**
     * Static nested class Link.
     * @param <E> generic
     */
    private static class Link<E> {
        /**
         * @param item object.
         */
        private E item;
        /**
         * @param prev previous Link
         */
        private Link<E> prev;
        /**
         * @param next next link
         */
        private Link<E> next;

        /**
         * Constructor.
         * @param prev previous Link
         * @param item object
         * @param next next link
         */
        Link(Link<E> prev, E item, Link<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
