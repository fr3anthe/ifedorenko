package ru.job4j.patterns.other.dao;

/**
 * DAOPattern.
 *
 * Data Access Object (DAO) — широко распространенный паттерн для сохранения объектов бизнес-области в базе данных.
 * В самом широком смысле, DAO — это класс, содержащий CRUD методы для конкретной сущности.
 *
 * В общем случае, определение Data Access Object описывает его как прослойку между БД и системой.
 * DAO абстрагирует сущности системы и делает их отображение на БД,
 * определяет общие методы использования соединения, его получение, закрытие и (или) возвращение в Connection Pool.
 * Вершиной иерархии DAO является абстрактный класс или интерфейс с описанием общих методов,
 * которые будут использоваться при взаимодействии с базой данных.
 * Как правило, это методы поиска, удаление по ключу, обновление и т.д.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class DAOPattern {
    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        Data data = new Db();
        System.out.println(data.getData());
        data = new FileSystem();
        System.out.println(data.getData());
    }
}
