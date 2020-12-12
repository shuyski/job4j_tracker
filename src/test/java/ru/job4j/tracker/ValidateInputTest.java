package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Set;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(Set.of("one", "1"))
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(Set.of("qwe", "0"))
        );
        ValidateInput input = new ValidateInput(out, in);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Please enter validate data again.%n")));
    }

    @Test
    public void whenNoInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<String>(Set.of("0"))
        );
        ValidateInput input = new ValidateInput(out, in);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"

                )
        ));
    }
}