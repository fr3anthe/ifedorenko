package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedSet.
 * @param <E> generic
 */
public class LinkedSet<E> implements SimpleSet<E> {
    /**
     * @param size size of container
     */
    private int size = 0;
    /**
     * @param first first element in container
     */
    private Node<E> first;
    /**
     * @param last last element in container
     */
    private Node<E> last;

    /**
     * Method add.
     * @param e element for adding.
     */
    @Override
    public void add(E e) {
        if (checkDuplicate(e)) {
            if (size > 0) {
                Node<E> newLink = new Node<>(last, e, null);
                last.next = newLink;
                last = newLink;
                size++;
            } else {
                first = new Node<>(null, e, null);
                last = first;
                size++;
            }
        }
    }

    /**
     * Method checkDuplicate.
     * @param e element for checking.
     * @return result.
     */
    private boolean checkDuplicate(E e) {
        boolean result = true;
        Node<E> temp = first;
        while (temp != null) {
            if (temp.item.equals(e)) {
                result = false;
                break;
            }
            temp = temp.next;
        }
        return result;
    }

    /**
     * Iterator.
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private Node<E> temp = first;
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
     * Getter size.
     * @return return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Static nested class Link.
     * @param <E> generic.
     */
    private static class Node<E> {
        /**
         * @param item object.
         */
        private E item;
        /**
         * @param prev previous Link
         */
        private Node<E> prev;
        /**
         * @param next next link
         */
        private Node<E> next;

        /**
         * Constructor.
         * @param prev previous Link
         * @param item object
         * @param next next link
         */
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
