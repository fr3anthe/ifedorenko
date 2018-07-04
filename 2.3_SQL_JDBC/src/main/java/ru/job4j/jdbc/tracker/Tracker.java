package ru.job4j.jdbc.tracker;


import ru.job4j.jdbc.tracker.sql.Database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
*Класс tracker.
*@author ifedorenko
*@since 04.07.2018
*@version 1
*/
public class Tracker implements AutoCloseable {
	/**
	 * @param db work with database
	 */
	private Database db;

	/**
	 * Constrcutor.
	 * @throws IOException exception
	 * @throws SQLException exception
	 */
	public Tracker() throws IOException, SQLException {
		this.db = new Database();
	}

	/**
	*Метод добавляет новую заявку в систему.
	*@param item заявка
	*/
	public void add(Item item) {
		db.add(item);
	}

	/**
	*Метод обновляет заявку в системе.
	*@param item заявка для обновления
	*/
	public void update(Item item) {
		db.update(item);
	}

	/**
	*Метод удаляет заявку из системы.
	*@param item заявка, которую необходимо удалить
	*/
	public void delete(Item item) {
		db.delete(item);
	}

	/**
	*@param key Имя заявки
	*/
	public void findByName(String key) {
		db.findByName(key);
	}

	/**
	 * Выводит список всех заявок.
	 */
	public void findAll() {
		db.findAll();
	}

	/**
	 *Метод ищет заявку по заданному id.
	 *@param id для поиска заявки
	 * @return id
	 */
	public String findById(int id) {
		return db.findById(id);
	}

	/**
	 * Общее количество добавленных заявок.
	 * @return size
	 */
	public int size() {
		return db.size();
	}

	/**
	 * Method close.
	 * @throws Exception exception
	 */
	@Override
	public void close() throws Exception {
		db.close();
	}
}