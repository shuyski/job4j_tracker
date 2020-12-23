package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "===== All items =====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ItemByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find by Id" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "===== Find item by id =====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find by Id" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ItemByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find by name" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
                + "===== Find items by name =====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find by name" + System.lineSeparator()
                + "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "7", "0"
                }
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }
}