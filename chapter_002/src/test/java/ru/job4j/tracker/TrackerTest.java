package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test Tracker.
* @author Igor Fedorenko (mailto:if.zommy@gmail.com)
* @version $Id$
* @since 0.1
*/
public class TrackerTest {
	/**
	* test add.
	*/
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1.1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test1.2", "testDescription", 234L);
		tracker.add(item2);
		assertThat(tracker.findAll()[1], is(item2));
	}
	/**
	* test update.
	*/
	@Test
	public void whenUpdateOldItemThenOldItemReplacNewItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test1.2", "testDescription", 234L);
		item2.setId(item1.getId());
		tracker.update(item2);
		assertThat(tracker.findAll()[0], is(item2));
	}
	/**
	* test delete.
	*/
	@Test
	public void whenDeleteItemWhenNextItemReplaceDeleteItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", 234L);
		tracker.add(item2);
		Item item3 = new Item("test3", "testDescription", 345L);
		tracker.add(item3);
		tracker.delete(item2);
		assertThat(tracker.findAll()[1], is(item3));
	}
	/**
	* test findAll.
	*/
	@Test
	public void whenFindAllItemsThenReturnArrayWithAllExistItems() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", 234L);
		tracker.add(item2);
		Item item3 = new Item("test3", "testDescription", 345L);
		tracker.add(item3);
		Item[] result = tracker.findAll();
		Item[] expect = {item1, item2, item3};
		assertThat(result, is(expect));
	}
	/**
	* return findByName.
	*/
	@Test
	public void whenFindByNameThenReturnArrayWithAllItemsWithOurName() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", 234L);
		tracker.add(item2);
		Item item3 = new Item("test1", "testDescription", 345L);
		tracker.add(item3);
		Item[] result = tracker.findByName("test1");
		Item[] expect = {item1, item3};
		assertThat(result, is(expect));
	}
	/**
	* return findById.
	*/
	@Test
	public void whenByIdThenReturnUniqueItemWithOurId() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "testDescription", 123L);
		tracker.add(item1);
		Item item2 = new Item("test2", "testDescription", 234L);
		tracker.add(item2);
		Item result = tracker.findById(item2.getId());
		Item expect = item2;
		assertThat(result, is(expect));
	}
}