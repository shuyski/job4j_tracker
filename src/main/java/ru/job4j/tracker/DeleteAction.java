package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки на удаление:");
        if (!tracker.delete(id)) {
            System.out.println("Номер заявки не найден");
        }
        else {
            System.out.println("Зявка с номером " + id + " успешно удалена");
        }
        System.out.println();
        return true;
    }
}
