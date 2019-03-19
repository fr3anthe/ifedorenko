package ru.job4j.streamandlambda.lambda;

import java.util.Scanner;
import java.util.function.*;

/**
 * Основные функциональные интерфейсы.
 *
 * @author ifedorenko
 * @since 31.10.2018
 */
public class MainFunctionalInterface {

    public static void main(String[] args) {
        // Predicate<T> проверяет соблюдение некоторого условия. Если оно соблюдается, то возвращается значение true, если нет - false. Метод test.
        Predicate<Integer> isZero = value -> value == 0;
        System.out.println(isZero.test(4));
        System.out.println(isZero.test(0));

        // Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая. Метод accept.
        Consumer<String> printer = string -> System.out.println(string);
        printer.accept("Hello world!");

        // Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R. Метод apply.
        Function<Integer, Double> converter = value -> Double.valueOf(value);
        System.out.println(converter.apply(5));

        // Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T. Метод get.
        Supplier<String> text = () -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter text: ");
                return scanner.nextLine();
            }
        };
        System.out.println(text.get());

        // UnaryOperator<T> принимает в качестве параметра объект типа T, выполняет над ними операции и
        // возвращает результат операций в виде объекта типа T. Метод apply.
        UnaryOperator<Double> sqrt = value -> Math.sqrt(value);
        System.out.println(sqrt.apply(4.0));

        // BinaryOperator<T> принимает в качестве параметра два объекта типа T, выполняет над ними бинарную операцию и
        // возвращает ее результат также в виде объекта типа T. Метод apply.
        BinaryOperator<Double> pow = (value1, value2) -> Math.pow(value1, value2);
        System.out.println(pow.apply(2d, 5d));
    }
}
