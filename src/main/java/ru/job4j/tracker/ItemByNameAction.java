package ru.job4j.tracker;


import java.util.List;

public class ItemByNameAction implements UserAction {
    private final Output out;

    public ItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===== Find items by name =====");
        String name = input.askStr("Введите имя:");
        List<Item> names = tracker.findByName(name);
        if (names.size() == 0) {
            out.println("Заявки с таким именем не найдены");
        }
        else {
            for (Item item : names) {
                out.println(item);
            }
        }
        System.out.println();
        return true;
    }
}
