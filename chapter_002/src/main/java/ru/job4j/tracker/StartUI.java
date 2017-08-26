package ru.job4j.tracker;
/**
 *Класс StartUI.
 *@author ifedorenko
 *@since 26.08.2017
 *@version 1
 */
public class StartUI {
	/**
	 *@param tracker хранит ссылку на объект.
	 */
	private Tracker tracker = new Tracker();
	/**
	 *@param хранит ссылку на объект .
	 */
	private Input input = new ConsoleInput();
	/**
	 *@param ADD переменная для добавления завки
	 */
	private static final String ADD = "0";
	/**
	 *@param SHOWALL переменная для отображения всех заявок
	 */
	private static final String SHOWALL = "1";
	/**
	 *@param EDIT переменная для редактирования заявок
	 */
	private static final String EDIT = "2";
	/**
	 *@param DELETE переменная для удаления заявок
	 */
	private static final String DELETE = "3";
	/**
	 *@param FINDBYID переменная для поиска заявки по id
	 */
	private static final String FINDBYID = "4";
	/**
	 *@param FINDBYNAME переменная для поиска заявки по имени пользователя
	 */
	private static final String FINDBYNAME = "5";
	/**
	 *@param EXIT переменная для выходи из программы
	 */
	private static final String EXIT = "6";
	/**
	 *@param menu переменная список меню
	 */
	private String[] menu = {"0. Add new item", "1. Show all items", "2. Edit item", "3. Delete item", "4. Find item by id", "5. Find items by name", "6. Exit program"};

	/**
	 * Медот выводит на экран основное меню.
	 */
	public void printMenu() {
		System.out.println("Вы находитесь в главном меню. Выберите необходимую опцию и нажмите соответствующую цифру:");
		for (String menu: this.menu) {
			System.out.println(menu);
		}
	}

	/**
	 * Метод для выбора пункта с меню.
	 * @param value пункт меню
	 */
	public void choiceMenu(String value) {
		if (ADD.equals(value)) {
			this.add();
		} else if (SHOWALL.equals(value)) {
			this.showAll();
		} else if (EDIT.equals(value)) {
			this.edit();
		} else if (DELETE.equals(value)) {
			this.delete();
		} else if (FINDBYID.equals(value)) {
			this.findById();
		} else if (FINDBYNAME.equals(value)) {
			this.findByName();
		} else if (EXIT.equals(value)) {
			System.out.println("Работа с программой завершена!");
		}
	}

	/**
	 * Метод для добавления заявки в систему.
	 */
	public void add() {
		String name = this.input.ask("Введите Ваше имя: ");
		String desc = this.input.ask("Введите описание: ");
		long curTime = System.currentTimeMillis();
		Item item = new Item(name, desc, curTime);
		this.tracker.add(item);
		System.out.println("В систему добавлена новая заявка с id: " + item.getId() + "\n");
		this.allAction();
	}

	/**
	 * Метод для отображения всех заявок в системе.
	 */
	public void showAll() {
		System.out.println("Список всех добавленных заявок:");
		for (Item item : this.tracker.findAll()) {
			System.out.println(item.getId());
		}
		System.out.println();
		this.allAction();
	}

	/**
	 * Метод для редактирования заявки в системе.
	 */
	public void edit() {
		String id = this.input.ask("Введите id заявки, которую необходимо отредактировать: ");
		String name = this.input.ask("Введите новое имя: ");
		String desc = this.input.ask("Введите новое описание: ");
		long curTime = System.currentTimeMillis();
		Item item = new Item(name, desc, curTime);
		item.setId(id);
		this.tracker.update(item);
		System.out.println("Ваша заявка отредактирована\n");
		this.allAction();
	}

	/**
	 * Метод для удаления заявки из системы.
	 */
	public void delete() {
		String id = this.input.ask("Введите id заявки, которую необходимо удалить: ");
		this.tracker.delete(this.tracker.findById(id));
		System.out.println("Заявка удалена\n");
		this.allAction();
	}

	/**
	 * Метод для поиска заявки в системе по id.
	 */
	public void findById() {
		String id = this.input.ask("Введите id заявки, которую необходимо отобразить: ");
		System.out.println(this.tracker.findById(id));
		System.out.println();
		this.allAction();
	}

	/**
	 * Метод для поиска заявок в системе по имени пользователя.
	 */
	public void findByName() {
		String name = this.input.ask("Введите Ваше имя, для  нахождения заявки: ");
		Item[] items = this.tracker.findByName(name);
		for (Item item : items) {
			System.out.println(item);
		}
		System.out.println();
		this.allAction();
	}

	/**
	 * Основной метод для работиы с меню.
	 */
	public void allAction() {
		this.printMenu();
		String s = this.input.ask("Select: ");
		this.choiceMenu(s);
	}

	/**
	 * Запуск программы.
	 * @param args для ввод из консоли
	 */
	public static void main(String[] args) {
		StartUI start = new StartUI();
		start.allAction();
	}
}