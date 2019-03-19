package ru.job4j.streamandlambda.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream API.
 *
 * C его помощью упрощается работа с набором данных за счет функционального стиля работы над потоком данных.
 * Поток данных в Stream API - это канал передачи данных из какого-нибудь источника.(Файл, массив, коллекции).
 * Поток данных представляет последовательность разных видов операций над набором данных.
 *
 * Все операции с потоками бывают либо терминальными(terminal), либо промежуточными(intermediate).
 * Промежуточные операции возвращают трансформированный поток. К возвращенному потоку также можно применить ряд промежуточных операций.
 * Конечные или терминальные операции возвращают конкретный результат. После этого никаких промежуточных операций естественно применять нельзя,
 * но можно использовать терминальные операции.
 *
 * Все потоки производят вычисления, в том числе в промежуточных операциях, только тогда, когда к ним применяется терминальная операция.
 * То есть в данном случае применяется отложенное выполнение.
 *
 * У потока данных 3 стадии жизни:
 *  1) Создание потока данных.
 *  2) Применение промежуточны операций.
 *  3) Применение терминальной операции. Получение результата.
 * @author ifedorenko
 * @since 31.10.2018
 */
public class MainStream {
    public static void main(String[] args) {

        //Методы stream(parallelStream) в Collection.

        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "Tom", "Jeff", "Edward");
        names.stream().
                filter(name -> name.length() >= 4).
                forEach(System.out::println);
    }
}
