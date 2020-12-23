package ru.job4j.tracker;

public class ItemByIdAction implements UserAction {
    private final Output out;

    public ItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("===== Find item by id =====");
        int id = input.askInt("Введите номер заявки:");
        Item item = tracker.findById(id);
        if (item == null) {
            out.println("Заявка с таким id не найдена");
        } else {
           out.println(item);
        }
        System.out.println();
        return true;
    }
}
