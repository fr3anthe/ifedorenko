package ru.job4j.set;


/**
 * Class LinkedContainer.
 * @param <E> generic
 */
public class LinkedContainer<E> extends AbstractLink<E> implements SimpleContainer<E> {
    /**
     * Method add.
     * @param e element for adding
     */
    @Override
    public void add(E e) {
        super.put(e);
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
        Node<E> temp;
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
    public E get(Node<E> link) {
        E result = link.item;
        return result;
    }
}
