package ru.job4j.streamandlambda.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Создание потока данных с использованием статического метода Arrays.steram.
 *
 * @author ifedorenko
 * @since 31.10.2018
 */
public class ArrayStream {
    public static void main(String[] args) {
        //Работа с массивом.
        Stream<String> objectStream = Arrays.stream(new String[]{"a", "b", "c"});
        objectStream.forEach(System.out::println);

        //Числовые потоки данных.
        IntStream intStream = Arrays.stream(new int[] {1, 1, 1});
        intStream.forEach(System.out::println);

        LongStream longStream = Arrays.stream(new long[] {2, 2, 2});
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = Arrays.stream(new double[] {3d, 3D, 3d});
        doubleStream.forEach(System.out::println);
    }
}
