package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер редактируемой заявки:");
        String nov = input.askStr("Введите новое имя:");
        Item item = new Item(id, nov);
        if (!tracker.replace(id, item)) {
            System.out.println("Номер заявки не найден");
        }
        else {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
