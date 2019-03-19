package ru.job4j.streamandlambda;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Объект является оберткой над резулшьтатом.
 *
 * Может находиться в 2ух состояниях:
 *      Содержит ссылку на T (также «present» или присутствует)
 *      Пуст (также «absent» или отсутствует.  Не употребляйте «null»)
 *
 * Реализации для примитивных типов:
 *      OptionalInt
 *      OptionalLong,
 *      OptionalDoube
 *
 * Правила
 *      Никогда не используйте null как значение Optional или в качестве возвращаемого значения
 *      Никогда не используйте Optional.get() без предварительной проверки Optional.isPresent()
 *      Выбирайте отличные способы работы с Optional, чем проверка на isPresent + get()
 *      В целом, создавать Optional только для того что бы получить из него значения — плохая идея. Лучше использовать тренарный оператор «?»
 *      Если есть вложенная цепочка Optional или промежуточный результат Optional<Optional<T>>, вероятно, это излишне
 *      Не используйте Optional в полях объекта, параметрах методов и коллекциях
 */
public class OptionalL {
    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of();
        Optional<Integer> result = numbers.min(Integer::compare);
        if (result.isPresent()) System.out.println(result.get());
        //ifPresenet. Выполняет заданные действия, если Optional содержит какое-нибудь значение.
        result.ifPresent(System.out::println);
        //orElse если не получит данные то вернет заданное значение.
        System.out.println(result.orElse(0));
        //ifPresentOrElse. Java 9.
        //orElseGet. Возвращает значение по умолчанию.
        System.out.println(result.orElseGet(() -> new Random().nextInt(100)));
        //orElseThrow позволяет генерировать исключение, если объект Optional не содержит значение.
        System.out.println(result.orElseThrow(RuntimeException::new));

    }
}
