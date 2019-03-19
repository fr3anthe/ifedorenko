package ru.job4j.streamandlambda.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Создание потока данных с использованием статического метода Stream.of.
 *
 * @author ifedorenko
 * @since 31.10.2018
 */
public class StreamOf {
    public static void main(String[] args) {

        Stream<String> objectOf = Stream.of("a", "b", "c");
        objectOf.forEach(System.out::println);

        IntStream intOf = IntStream.of(1, 2, 3);
        intOf.forEach(System.out::println);

        LongStream longOf = LongStream.of(4, 5, 6);
        longOf.forEach(System.out::println);

        DoubleStream doubleOf = DoubleStream.of(7d, 8d, 9d);
        doubleOf.forEach(System.out::println);
    }
}
