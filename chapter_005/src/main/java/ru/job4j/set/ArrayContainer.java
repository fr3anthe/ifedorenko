package ru.job4j.set;


/**
 * Class ArrayContainer.
 * @param <E> generic
 */
public class ArrayContainer<E> extends AbstractArray implements SimpleContainer<E> {
    /**
     * Base constructor.
     */
    public ArrayContainer() {
        super();
    }

    /**
     * Constructor.
     * @param initialCapacity start size
     */
    public ArrayContainer(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void add(E e) {
        super.put(e);
    }

    /**
     * Method get.
     * @param index position for return.
     * @return object.
     */
    @Override
    public E get(int index) {
        E result = null;
        if (index >= super.objects.length) {
            throw new IndexOutOfBoundsException();
        } else {
            result = (E) objects[index];
        }
        return result;
    }
}
