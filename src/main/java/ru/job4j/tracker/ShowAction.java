package ru.job4j.tracker;

public class ShowAction implements UserAction{
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===== All items =====");
        Item[] names = tracker.findAll();
        for (Item value : names) {
            out.println(value);
        }
        System.out.println();
        return true;
    }
}
