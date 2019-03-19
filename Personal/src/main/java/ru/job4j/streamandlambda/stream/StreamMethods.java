package ru.job4j.streamandlambda.stream;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Некоторые методы использующиеся в Stream Api.
 *
 * @author ifedorenko
 * @since 31.10.2018
 */
public class StreamMethods {
    public static void main(String[] args) {

        //Inter method skip. В потоке данных пропускаютеся первые n элементов
        Stream<String> streamSkip = Stream.of("value1", "value2", "value3", "value4", "value5");
        streamSkip.skip(2).forEach(System.out::println);

        System.out.println("----------------------------");

        //Inter method limit. В потоке данных остаются первые n элементы.
        Stream<String> streamLimit = Stream.of("value1", "value2", "value3", "value4", "value5");
        streamLimit.limit(2).forEach(System.out::println);

        System.out.println("----------------------------");

        //Inter method map. Принимает объект типа Function.
        Stream<Pizza> pizzaTitle = Stream.of(new Pizza("Peperonni", 20), new Pizza(" Four Cheesses", 25));
        pizzaTitle.map(Pizza::getTitle).forEach(System.out::println);

        System.out.println("----------------------------");

        //Inter method flatMap. Позволяет из одного объекта потока данных получить несколько.
        Stream<Pizza> pizzaPrice = Stream.of(new Pizza("Peperonni", 20));
        pizzaPrice.flatMap(pizza -> Stream.of(
                String.format("Pizza: %s, price: %d", pizza.getTitle(), pizza.getPrice()),
                String.format("(HAPPRY HOURS DISCOUNT - 50%%)%nPizza: %s, price: %d", pizza.getTitle(), pizza.getPrice()/2)
        )).forEach(System.out::println);

        System.out.println("----------------------------");

        //Terminal method AllMatch. Возвращает true если ВСЕ элементы потока данных выполнят условия в Predicate. Иначе false.
        Stream<Integer> mixedNumbers1 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers1.allMatch(number -> number > 0));
        Stream<Integer> positiveNumbers1 = Stream.of(1, 2);
        System.out.println(positiveNumbers1.allMatch(number -> number > 0));
        Stream<Integer> netativeNumbers1 = Stream.of(-2, -1);
        System.out.println(netativeNumbers1.allMatch(number -> number > 0));

        System.out.println("----------------------------");

        //Terminal method AnyMatch. Возвращает true если хотя бы ОДИН эелемент потока данных выполнит условия в Predicate. Иначе false.
        Stream<Integer> mixedNumbers2 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers2.anyMatch(number -> number > 0));
        Stream<Integer> positiveNumbers2 = Stream.of(1, 2);
        System.out.println(positiveNumbers2.anyMatch(number -> number > 0));
        Stream<Integer> netativeNumbers2 = Stream.of(-2, -1);
        System.out.println(netativeNumbers2.anyMatch(number -> number > 0));

        System.out.println("----------------------------");

        //Terminal method NoneMatch. Возвращает true если НИ ОДИН из элементов потока не выполнит условия проверки (Predicate). Иначе false.
        Stream<Integer> mixedNumbers3 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers3.noneMatch(number -> number > 0));
        Stream<Integer> positiveNumbers3 = Stream.of(1, 2);
        System.out.println(positiveNumbers3.noneMatch(number -> number > 0));
        Stream<Integer> netativeNumbers3 = Stream.of(-2, -1);
        System.out.println(netativeNumbers3.noneMatch(number -> number > 0));

        System.out.println("----------------------------");

        //Terminal method count. Возвращает количество данных в потоке.
        Stream<Integer> mixedNumbers4 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(mixedNumbers4.count());

        System.out.println("----------------------------");

        //Inter methods min and max. Выводит max/min значение в зависимости от результата Comparator.
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("A", 100));
        tickets.add(new Ticket("B", 75));

        Ticket minimumTicketPrice = tickets.stream().min(Ticket::compare).get();
        System.out.printf("Minimum price of ticket class %s: $%d%n", minimumTicketPrice.getTicketClass(), minimumTicketPrice.getPrice());
        Ticket maximumTicketPrice = tickets.stream().max(Ticket::compare).get();
        System.out.printf("Minimum price of ticket class %s: $%d%n", maximumTicketPrice.getTicketClass(), maximumTicketPrice.getPrice());

        System.out.println("----------------------------");

        //Inter method Reduce. Выполняет бинарную операцию сведения. Используется BinaryOperator.
        //Var 1. Cкладывает 1 + 2 = 3 + 3 = 6 + 4 = 10 + 5 = 15. Необходимо использовать Optional.
        Stream<Integer> numbers1 = Stream.of(1, 2, 3 ,4 ,5);
        Optional<Integer> result1 = numbers1.reduce((value1, value2) -> value1 + value2);
        System.out.println(result1.get());
        //Var 2. Без использования Optional.
        Stream<Integer> numbers2 = Stream.of(1, 2, 3 ,4 ,5);
        int result2 = numbers2.reduce(0,(value1, value2) -> value1 + value2);
        System.out.println(result2);
        //Var 3. Получение промежуточных решений.
        // 1 lamиda для получения промежуточных выражений.
        // 2-й lambda для выполнения определенных результатов над промежуточными выражениями.
        Stream<Integer> numbers3 = Stream.of(1, 2, 3 ,4 ,5);
        int result3 = numbers3.reduce(0,(value1, value2) -> {
            if (value2 < 5) {
                return value1 + value2;
            } else {
                return value1;
            }
        }, (value1, value2) -> value1 + value2);
        System.out.println(result3);
    }
    //help classes
    static class Pizza {
        private String title;
        private int price;

        public Pizza(String title, int price) {
            this.title = title;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public int getPrice() {
            return price;
        }
    }

    static class Ticket {
        private String ticketClass;
        private int price;

        public Ticket(String ticketClass, int price) {
            this.ticketClass = ticketClass;
            this.price = price;
        }

        public String getTicketClass() {
            return ticketClass;
        }

        public int getPrice() {
            return price;
        }

        public static int compare(Ticket t1, Ticket t2) {
            if (t1.getPrice() > t2.getPrice()) return 1;
            return -1;
        }
 }
}