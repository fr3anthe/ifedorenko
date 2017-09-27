package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class findCycle.
 */
public class FindCycle {
    /**
     * Method hasCycle.
     * @param first start node
     * @return result
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        Node temp = first.getNext();
        List<Node> list = new ArrayList();
        list.add(first);
        while (true) {
            if (temp.getNext() == null) {
                break;
            } else if (list.contains(temp)) {
                result = true;
                break;
            } else {
                list.add(temp);
                temp = temp.getNext();
            }
        }
        return result;
    }
}
