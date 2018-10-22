package ru.job4j.javacode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Поиск минимального пропущенного числа.
 *
 * @author ifedorenko
 * @since 14.09.2018
 */
public class MinMissValue {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MinMissValue.class);

    /**
     * Method find value.
     * @param args args
     */
    public void findValue(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (String s : args) {
            list.add(Integer.valueOf(s));
        }
        Collections.sort(list);
        int last = list.getFirst();
        for (int i : list) {
            if (i != last && i - 1 != last) {
                System.out.println(last + 1);
                break;
            } else {
                last = i;
            }
        }
    }

    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        String[] values = {"2", "5", "3", "14", "6", "77", "9", "1", "11", "12"};
        MinMissValue minMissValue = new MinMissValue();
        minMissValue.findValue(values);
     }
}
