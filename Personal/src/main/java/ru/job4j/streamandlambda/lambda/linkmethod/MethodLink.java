package ru.job4j.lambdas.linkmethod;


import java.util.function.Consumer;

/**
 * Ссылки на методы и конструкторы.
 *
 * @author ifedorenko
 * @since 31.10.2018
 */
public class MethodLink {

    private static void printLn(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Consumer<String> print = MethodLink::printLn;
        print.accept("Hello world!");
    }
}
