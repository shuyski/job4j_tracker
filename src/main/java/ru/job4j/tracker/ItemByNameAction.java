package ru.job4j.tracker;

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
