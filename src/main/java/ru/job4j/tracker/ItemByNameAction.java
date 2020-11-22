package ru.job4j.tracker;

public class ItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя:");
        Item[] names = tracker.findByName(name);
        if (names.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
        }
        else {
            for (Item item : names) {
                System.out.println(item);
            }
        }
        System.out.println();
        return true;
    }
}
