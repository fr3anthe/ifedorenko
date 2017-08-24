package ru.job4j.tracker;


import java.util.Arrays;
import java.util.Random;

/**
*Класс tracker.
*@author ifedorenko
*@since 24.08.2017
*@version 1
*/
public class Tracker {
	/**
	*@param для получения рандомного числа
	*/
	private static final Random RN = new Random();
	/**
	*@param массив на 100 элементов, для хранения заявок
	*/
	private Item[] items = new Item[100];
	/**
	*@param текущая позиция в массиве
	*/
	private int position = 0;
	/**
	*Метод добавляет новую заявку в систему.
	*@param item заявка
	*@return item
	*/
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}
	/**
	*Метод обновляет заявку в системе.
	*@param item заявка для обновления
	*/
	public void update(Item item) {
		String id = item.getId();
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
				break;
			}
		}
	}
	/**
	*Метод удаляет заявку из системы.
	*@param item заявка, которую необходимо удалить
	*/
	public void delete(Item item) {
		String id = item.getId(); //получаем id удаляемого объекта
		int length = this.items.length;
		for (int i = 0; i < length; i++) {
				if (this.items[i].getId().equals(id)) { //ищем по id элемент, который хотим удалить.
					int pos = length - 1 - i;
					System.arraycopy(this.items, i + 1, this.items, i, pos);
					this.items[this.position - 1] = null;
					this.position--;
					break;
				}
		}
	}
	/**
	*Метод ищет все заведенные заявки в системе..
	*@return массив из заведенных в систему заявок
	*/
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	/**
	*@param key Имя заявки
	*@return Массив из элементов, с заданным именем
	*/
	public Item[] findByName(String key) {
		int index = 0;
		Item[] result = new Item[position];
		for (int i = 0; i != this.position; i++) {
			if (this.items[i].getName().equals(key)) {
				result[index++] = this.items[i]; //Добавляем в массив элемент, у которого getName совпадает с key
			}
		}
		return Arrays.copyOf(result, index); //возвращаем массив без элементов с null
	}
	/**
	*Метод генерирует id для заявки.
	*@return id
	*/
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	/**
	*Метод ищет заявку по заданному id.
	*@param id для поиска заявки
	*@return заявку с заданным id
	*/
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
}