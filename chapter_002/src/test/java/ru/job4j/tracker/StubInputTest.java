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
public class StubInputTest {
    /**
     * Test add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Igor", "desc", "6"});
        new StartUI(input, tracker).allAction();
        assertThat(tracker.findAll()[0].getName(), is("Igor"));
    }
    /**
     * Test SHow All.
     */
    @Test
    public void whenShowAllThenTrackerReturnAllExistItems() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Igor", "desc1", "0", "Dima", "desc2", "1", "6"});
        new StartUI(input, tracker).allAction();

    }
    /**
     * Test Update.
     */
    @Test
    public void whenUserUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).allAction();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    /**
     * Test Delete.
     */
    @Test
    public void whenUserDeleteItemWhenNextItemReplaceDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item());
        Item item2 = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).allAction();
        assertThat(tracker.findAll()[0], is(item2));
    }
    /**
     * Test FindById.
     */
    @Test
    public void whenUserFindByIdThenReturnItemWithOurId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).allAction();
    }

    /**
     * Test FindByName.
     */
    @Test
    public void whenUserFindByNameThenReturnAllItemsWithOurName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "igor", "desc1", "0", "dima", "desc2", "0", "igor", "desc3", "5", "igor", "6"});
        new StartUI(input, tracker).allAction();
    }
}