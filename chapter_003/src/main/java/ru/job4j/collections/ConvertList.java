package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;
/**
 *Класс ConvertList.
 *@author ifedorenko
 *@since 06.09.2017
 *@version 1
 */
public class ConvertList {
    /**
     * Метод добавляет все элементы из массива в коллекцию типа ArrayList.
     * @param array массив, который мы хотим добавить в коллекцию.
     * @return коллекцию, состоящую из элементов переданного массива.
     */
    public List<Integer> toList(int[][] array) {
        int length = array.length;
        List<Integer> list = new ArrayList<>(length);
        for (int[] values : array) {
            for (int value : values) {
                list.add(value);
            }
        }
        return list;
    }

    /**
     * Метод позволяет извлечь элементы из коллекции и передать их в массив.
     * @param list Коллекция для извлечения элементов
     * @param rows Количество вложенных массив.
     * @return массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int col = size % rows == 0 ? size / rows : (size + rows) / rows; //определяем сколько элементов будет в каждой строке.
        int index = 0;
        int[][] result = new int[rows][col];
        for (int value : list) {
            result[index / col][index++ % col] = value;
            }
        return result;
    }
}
