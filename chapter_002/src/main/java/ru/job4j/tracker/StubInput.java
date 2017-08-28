package ru.job4j.tracker;
/**
*Класс StubInput.
*@author ifedorenko
*@since 27.08.2017
*@version 1
*/
public class StubInput implements Input {
	/**
	 * @param answers массив строк для последовательности действий.
	 */
	private String[] answers;
	/**
	 * @param position счетчик.
	 */
	private int position = 0;

	/**
	 * Конструктор.
	 * @param answers массив строк для последовательности действий.
	 */
	public StubInput(String[] answers) {
		this.answers = answers;
	}
	/**
	 * Медот для тестирования приложения tracker.
	 * @param question Вопрос-подсказка для пользователя.
	 * @return ответ из заданного массива.
	 */
	public String ask(String question) {
		return answers[position++];
	}
}