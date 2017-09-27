package ru.job4j.list;

/**
 * Class Node.
 * @param <T> generic
 */
public class Node<T> {
    /**
     * @param value saving value
     */
    private T value;
    /**
     * @next next link
     */
    private Node<T> next;

    /**
     * Constructor.
     * @param value saving value
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Getter next.
     * @return next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter next.
     * @param next next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
