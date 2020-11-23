package ru.job4j.tracker;

public class ItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки:");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена");
        }
        else {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
