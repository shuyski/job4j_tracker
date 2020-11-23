package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки на удаление:");
        if (!tracker.delete(id)) {
            out.println("Номер заявки не найден");
        }
        else {
            out.println("Зявка с номером " + id + " успешно удалена");
        }
        System.out.println();
        return true;
    }
}
