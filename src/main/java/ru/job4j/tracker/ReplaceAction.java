package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===== Replace item =====");
        int id = input.askInt("Введите номер редактируемой заявки:");
        String nov = input.askStr("Введите новое имя:");
        Item item = new Item(id, nov);
        if (!tracker.replace(id, item)) {
            out.println("Номер заявки не найден");
        }
        else {
            out.println(item);
        }
        System.out.println();
        return true;
    }
}
