package ru.job4j.streamandlambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Группировка данных.
 */
public class GroupData {

    public static void main(String[] args) {
        //partitiongBy. Сортирует по Boolen.
        Stream<Computer> stream1 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<Boolean, List<Computer>> computers1 = stream1.collect(Collectors.partitioningBy(c -> c.getPrice() > 1000));
        for (Map.Entry<Boolean, List<Computer>> item : computers1.entrySet()) {
            if (item.getKey()) {
                showProducts("more", item);
            } else {
                showProducts("less", item);
            }
        }

        //groupingBy. Сортирует по одному из параметров.
        Stream<Computer> stream2 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, List<Computer>> computers2 = stream2.collect(Collectors.groupingBy(Computer::getType));
        for (Map.Entry<String, List<Computer>> item : computers2.entrySet()) {
            System.out.println("Type: " + item.getKey());

            for (Computer c : item.getValue()) {
                System.out.printf("Company: %s, Model %s, Price: %d %n", c.getCompany(), c.getModel(), c.getPrice());
            }
            System.out.println();
        }
        /**
         * Вспомогательные методы, которые используюется в качестве второго параметра метода groupingBy.
         */

        //counting. Используется для потсчета элементов потока заданного типа.
        Stream<Computer> stream3 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, Long> computers3 = stream3.collect(Collectors.groupingBy(Computer::getCompany, Collectors.counting()));
        for (Map.Entry<String, Long> item : computers3.entrySet()) {
            System.out.printf("Total values of computers in %s: %d %n", item.getKey(), item.getValue());
        }

        //summingInt, summingLong, summintDouble
        Stream<Computer> stream4 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, Integer> computers4 = stream4.collect(Collectors.groupingBy(Computer::getType, Collectors.summingInt(Computer::getPrice)));
        for (Map.Entry<String, Integer> item : computers4.entrySet()) {
            System.out.printf("%s total cost: %d %n", item.getKey(), item.getValue());
        }

        //summarizingInt(IntSummaryStatistics), summarizingLong(LongSummaryStatistics), summarizingDouble(DoubleSummaryStatistics)
        Stream<Computer> stream5 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, IntSummaryStatistics> computers5 = stream5.collect(Collectors.groupingBy(Computer::getType, Collectors.summarizingInt(Computer::getPrice)));
        for (Map.Entry<String, IntSummaryStatistics> item : computers5.entrySet()) {

            System.out.printf("Value of %s: %d %n", item.getKey(), item.getValue().getCount());
            System.out.printf("Minimum price of %s: %d %n", item.getKey(), item.getValue().getMin());
            System.out.printf("Maximum price of %s: %d %n", item.getKey(), item.getValue().getMax());
            System.out.printf("Average price of %s: %.2f %n", item.getKey(), item.getValue().getAverage());
            System.out.printf("Total cost of %s: %d %n", item.getKey(), item.getValue().getSum());
            System.out.println();
        }

        //minBy, maxBy (Optional)
        Stream<Computer> stream6 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, Optional<Computer>> computers6 = stream6.collect(Collectors.groupingBy(Computer::getType, Collectors.minBy(Comparator.comparing(Computer::getPrice))));
        for (Map.Entry<String, Optional<Computer>> item : computers6.entrySet()) {
            System.out.printf("Minimum price of %s on the model: %s %n", item.getKey(), item.getValue().get().getModel());
        }

        //mapping
        Stream<Computer> stream7 = Stream.of(new Computer("Desktop", "Apple", "iMac", 2299),
                new Computer("Laptop", "Asus", "Asus rog", 3199),
                new Computer("Laptop", "Google", "Google PixelBook", 799),
                new Computer("Desktop", "Dell", "Inspiron", 549));

        Map<String, List<String>> computers7 = stream7.collect(Collectors.groupingBy(Computer::getType, Collectors.mapping(Computer::getCompany, Collectors.toList())));
        for (Map.Entry<String, List<String>> item : computers7.entrySet()) {
            System.out.println(item.getKey());

            for (String model : item.getValue()) {
                System.out.println(model);
            }
            System.out.println();
        }
    }


    private static void showProducts(String status, Map.Entry<Boolean, List<Computer>> item) {
        System.out.printf("Price is %s than $1000: %n", status);

        for (Computer c : item.getValue()) {
            System.out.printf("Type: %s, Company: %s, Model %s %n", c.getType(), c.getCompany(), c.getModel());
        }
        System.out.println();
    }

    /**
     * Help classes
     */
    private static class Computer {
        private String type, company, model;
        private int price;

        public Computer(String type, String company, String model, int price) {
            this.type = type;
            this.company = company;
            this.model = model;
            this.price = price;
        }

        public String getType() {
            return type;
        }

        public String getCompany() {
            return company;
        }

        public String getModel() {
            return model;
        }

        public int getPrice() {
            return price;
        }
    }
}
