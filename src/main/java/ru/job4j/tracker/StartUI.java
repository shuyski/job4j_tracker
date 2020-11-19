package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {this.showMenu();
            //System.out.print("Select: ");
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 :
                System.out.println("=== Create a new Item ====");
                //System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(23, name);
                tracker.add(item);
                    System.out.println();
                break;
                case 1 :
                    System.out.println("Show all items:");
                    Item[] names = tracker.findAll();
                    for (Item value : names) {
                        System.out.println(value);
                    }
                    break;
                case 2 :
                    int id;
                    //System.out.println("Введите номер редактируемой заявки:");
                    id = input.askInt("Введите номер редактируемой заявки:");
                    //System.out.println("Введите новое имя:");
                    String nov = input.askStr("Введите новое имя:");
                    item = new Item(id, nov);
                    if (!tracker.replace(id, item)) {
                        System.out.println("Номер заявки не найден");
                        System.out.println();
                        }
                    else {
                        System.out.println(item);
                        System.out.println();
                    }
                    break;
                case 3 :
                    //System.out.println("Введите номер заявки на удаление:");
                    id = input.askInt("Введите номер заявки на удаление:");
                    if (!tracker.delete(id)) {
                        System.out.println("Номер заявки не найден");
                        System.out.println();
                    }
                    else {
                        System.out.println("Зявка с номером " + id + " успешно удалена");
                        System.out.println();
                    }
                    break;
                case 4 :
                    //System.out.println("Введите номер заявки:");
                    id = input.askInt("Введите номер заявки:");
                    item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("Заявка с таким id не найдена");
                        System.out.println();
                    }
                    else {
                        System.out.println(item);
                        System.out.println();
                    }
                    break;
                case 5 :
                    //System.out.println("Введите имя:");
                    name = input.askStr("Введите имя:");
                    names = tracker.findByName(name);
                    if (names.length == 0) {
                        System.out.println("Заявки с таким именем не найдены");
                        System.out.println();
                    }
                    else {
                        for (int i = 0; i < names.length; i++) {
                            System.out.println(names[i]);
                        }
                        System.out.println();
                    }
                    break;
                case 6 :
                run = false;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();

    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

