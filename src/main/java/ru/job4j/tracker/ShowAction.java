package ru.job4j.tracker;

public class ShowAction implements UserAction{
    @Override
    public String name() {
        return "Show all items:";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] names = tracker.findAll();
        for (Item value : names) {
            System.out.println(value);
        }
        System.out.println();
        return true;
    }
}
