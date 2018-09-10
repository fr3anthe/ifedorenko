package ru.job4j.patterns.creational.prototype;

/**
 * PrototypePattern.
 *
 * Прототип — это порождающий паттерн проектирования,
 * который позволяет копировать объекты, не вдаваясь в подробности их реализации.
 *
 * Паттерн Прототип поручает создание копий самим копируемым объектам.
 * Он вводит общий интерфейс для всех объектов, поддерживающих клонирование.
 * Это позволяет копировать объекты, не привязываясь к их конкретным классам.
 * Обычно такой интерфейс имеет всего один метод clone.
 *
 * Используется интерфейс Cloneable.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class PrototypePattern {
    /**
     * Method main.
     * @param args args
     * @throws CloneNotSupportedException exception
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePizza cheesePizza = new ConcretePizza();
        cheesePizza.setSize("XL");
        cheesePizza.setSauce("BBQ");
        cheesePizza.setCheese("Mozzarella, Parmesan");
        System.out.println(cheesePizza.toString());

        ConcretePizza mushroomPizza = (ConcretePizza) cheesePizza.make();
        mushroomPizza.setMushrooms("Champignons");
        System.out.println(mushroomPizza.toString());

        ConcretePizza sausagesPizza = (ConcretePizza) mushroomPizza.make();
        sausagesPizza.setSausages("Bavarian sausages");
        System.out.println(sausagesPizza.toString());

    }
}
