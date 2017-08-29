package ru.job4j.tracker;
/**
 *Класс FindItemById.
 */
class FindItemById implements UserAction {
	/**
	 * Метод возвращает ключ опции.
	 * @return ключ
	 */
	public int key() {
		return 4;
	}
	/**
	 * Основной метод. Ищет заявку по id.
	 * @param input объект типа Input
	 * @param tracker объект типа Tracker
	 */
	public void execute(Input input, Tracker tracker) {
		String id = input.ask("Please, enter id of task you want to see: ");
		System.out.println(tracker.findById(id) + "\n");
	}
	/**
	 * Метод возвращает информацию о данном пункте меню.
	 * @return Строка меню
	 */
	public String info() {
		return String.format("%s. %s", this.key(), "Find item by Id.");
	}
}
/**
 *Класс FindItemsByName.
 */
class FindItemsByName implements UserAction {
	/**
	 * Метод возвращает ключ опции.
	 * @return ключ
	 */
	public int key() {
		return 5;
	}
	/**
	 * Основной метод. Ищет заявки по name.
	 * @param input объект типа Input
	 * @param tracker объект типа Tracker
	 */
	public void execute(Input input, Tracker tracker) {
		String name = input.ask("Please, enter name of tasks you want to see: ");
		Item[] items = tracker.findByName(name);
		System.out.println("List of all added tasks with name:" + name);
		for (Item item : items) {
			System.out.println(item);
		}
		System.out.println();
	}
	/**
	 * Метод возвращает информацию о данном пункте меню.
	 * @return Строка меню
	 */
	public String info() {
		return String.format("%s. %s", this.key(), "Find items by name.");
	}
}

/**
 * Класс MenuTracker. Основной класс в файле.
 *@author ifedorenko
 *@since 28.08.2017
 *@version 1
 */
public class MenuTracker {
	/**
	 *@param хранит ссылку на объект .
	 */
	private Input input;
	/**
	 *@param хранит ссылку на объект .
	 */
	private Tracker tracker;
	/**
	 *@param хранит ссылку на массив типа UserAction.
	 */
	private UserAction[] actions = new UserAction[7];

	/**
	 * Конструктор.
	 * @param input объект типа Input
	 * @param tracker объект типа Tracker
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	/**
	 * Метод для получения массива меню.
	 * @return длину массива
	 */
	public int getActionsLentgh() {
		return this.actions.length;
	}
	/**
	 * Метод заполняет массив.
	 */
	public void fillActions() {
		this.actions[0] = new AddItem();
		this.actions[1] = new ShowItems();
		this.actions[2] = new MenuTracker.EditItem();
		this.actions[3] = new MenuTracker.DeleteItem();
		this.actions[4] = new FindItemById();
		this.actions[5] = new FindItemsByName();
		this.actions[6] = new ExitProgram();
	}

	/**
	 * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
	 * @param key ключ операции
	 */
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}

	/**
	 * Метод выводит на экран меню.
	 */
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
			System.out.println(action.info());
			}
		}
	}
	/**
	 * Внутренний класс ExitProgram.
	 */
	private class ExitProgram implements UserAction {
		/**
		 * Метод возвращает ключ опции.
		 * @return ключ
		 */
		public int key() {
			return 6;
		}
		/**
		 * Основной метод. Выход из программы.
		 * @param input объект типа Input
		 * @param tracker объект типа Tracker
		 */
		public void execute(Input input, Tracker tracker) {
		}
		/**
		 * Метод возвращает информацию о данном пункте меню.
		 * @return Строка меню
		 */
		public String info() {
			return String.format("%s. %s", this.key(), "Exit Program.");
		}
	}
	/**
	 * Внутренний класс AddItem.
	 */
	private class AddItem implements UserAction {
		/**
		 * Метод возвращает ключ опции.
		 * @return ключ
		 */
		public int key() {
			return 0;
		}
		/**
		 * Основной метод. Добавляет заявку.
		 * @param input объект типа Input
		 * @param tracker объект типа Tracker
		 */
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");
			long curTime = System.currentTimeMillis();
			String id = tracker.add(new Item(name, desc, curTime)).getId();
			System.out.println("In system added new task with id: " + id + "\n");
		}
		/**
		 * Метод возвращает информацию о данном пункте меню.
		 * @return Строка меню
		 */
		public String info() {
			return String.format("%s. %s", this.key(), "Add the new item.");
		}
	}
	/**
	 * Внутренний класс ShowItems.
	 */
	private class ShowItems implements UserAction {
		/**
		 * Метод возвращает ключ опции.
		 * @return ключ
		 */
		public int key() {
			return 1;
		}
		/**
		 * Основной метод. Показывает список добавленных заявок.
		 * @param input объект типа Input
		 * @param tracker объект типа Tracker
		 */
		public void execute(Input input, Tracker tracker) {
			System.out.println("List of all added tasks:");
			for (Item item : tracker.findAll()) {
				System.out.printf("%s, %s", item.getId(), item.getName() + "\n");
			}
		}
		/**
		 * Метод возвращает информацию о данном пункте меню.
		 * @return Строка меню
		 */
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items.");
		}
	}
	/**
	 * Вложенный класс EditItem.
	 */
	private static class EditItem implements UserAction {
		/**
		 * Метод возвращает ключ опции.
		 * @return ключ
		 */
		public int key() {
			return 2;
		}
		/**
		 * Основной метод. Изменяет заявку.
		 * @param input объект типа Input
		 * @param tracker объект типа Tracker
		 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Enter id of task you want to edit: ");
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");
			long curTime = System.currentTimeMillis();
			Item item = new Item(name, desc, curTime);
			item.setId(id);
			tracker.update(item);
			System.out.println("Ваша заявка отредактирована\n");
		}
		/**
		 * Метод возвращает информацию о данном пункте меню.
		 * @return Строка меню
		 */
		public String info() {
			return String.format("%s. %s", this.key(), "Edit item.");
		}
	}
	/**
	 * Вложенный класс DeleteItem.
	 */
	private static class DeleteItem implements UserAction {
		/**
		 * Метод возвращает ключ опции.
		 * @return ключ
		 */
		public int key() {
			return 3;
		}
		/**
		 * Основной метод. Удаляет заявку.
		 * @param input объект типа Input
		 * @param tracker объект типа Tracker
		 */
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter id of task you want to delete: ");
			tracker.delete(tracker.findById(id));
			System.out.println("Task is delete \n");
		}
		/**
		 * Метод возвращает информацию о данном пункте меню.
		 * @return Строка меню
		 */
		public String info() {
			return String.format("%s. %s", this.key(), "Delete item.");
		}
	}

}