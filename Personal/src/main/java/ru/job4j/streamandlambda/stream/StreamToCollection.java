package ru.job4j.streamandlambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Приведение потока к коллекции.
 */
public class StreamToCollection {
    public static void main(String[] args) {
        /**
         * Первый случай использования метода collect.
         */
        //to  ArrayList
        Stream<String> values1 = Stream.of("Value 1","Value 2", "Value 3", "Value 4", "Value 5");
        List<String> result1 = values1.collect(Collectors.toList());
        System.out.printf("result1: %d%n", result1.size());

        //to HashSet
        Stream<String> values2 = Stream.of("Value 1","Value 2", "Value 3", "Value 4", "Value 5");
        Set<String> result2 = values2.collect(Collectors.toSet());
        System.out.printf("result2: %d%n", result2.size());

        //Если необходимо привести к конкретной коллекции
        Stream<String> values3 = Stream.of("Value 1","Value 2", "Value 3", "Value 4", "Value 5");
        List<String> result3 = values3.collect(Collectors.toCollection(LinkedList::new));
        System.out.printf("result3: %d%n", result3.size());

        //to Map
        Stream<Order> values4 = Stream.of(new Order(0, "context 1"), new Order(1, "context 2"));
        Map<Integer, String> result4 = values4.collect(Collectors.toMap(Order::getId, Order::getContext));
        System.out.printf("result4: %d%n", result4.size());

        /**
         * Второй случай использования метода collect подразумевает использование трех параметров:
         *      Объектов коллекции
         *      Ф-ии добавления элемента в коллекцию
         *      Ф-ия, которая объединяет два объекта
         *
         */
        Stream<String> values5 = Stream.of("Value 1","Value 2", "Value 3", "Value 4", "Value 5");
        List<String> result5 = values5.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.printf("result5: %d%n", result5.size());
    }
    /**
     * Help classes
     */
    static class Order {
        private int id;
        private String context;

        public Order(int id, String context) {
            this.id = id;
            this.context = context;
        }

        public int getId() {
            return id;
        }

        public String getContext() {
            return context;
        }
    }
}

