package ru.job4j.personaltasks;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Класс dependence.
 */
public class Dependence {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * Получаем список и загружаем полученные из него данные в HashMap.
     * @throws FileNotFoundException erroк
     */
    private void add() throws FileNotFoundException {
        Scanner gPath = new Scanner(System.in); //Для чтения введенного пути, где лежит файла.
        System.out.println("Укажите путь к файлу:");
        Scanner scanner = new Scanner(new File(gPath.nextLine())); //чтение файла по указанному пути.

        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            this.map.put(key, value);
        }
    }

    /**
     * Находим циклические зависимости и выводим их на экран.
     */
    private void findCircualDependencies() {
        int count = 0;
        for (Map.Entry<Integer, Integer> val : this.map.entrySet()) {
            for(Map.Entry<Integer, Integer> ind : this.map.entrySet()) {
                if (val.getKey().equals(ind.getValue()) && val.getValue().equals(ind.getKey())) {
                    System.out.println(val.getKey() + " " + ind.getKey() + " " + ind.getValue());
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Циклические зависимости не обнаружены");
        }
    }

    /**
     * Запуск программы в работу.
     * @throws FileNotFoundException error
     */
    public void init() throws FileNotFoundException {
        this.add();
        this.findCircualDependencies();
    }

}
