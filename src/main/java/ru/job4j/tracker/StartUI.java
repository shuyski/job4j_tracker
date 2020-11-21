package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void show(Tracker tracker) {
        System.out.println("Show all items:");
        Item[] names = tracker.findAll();
        for (Item value : names) {
            System.out.println(value);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id;
        id = input.askInt("Введите номер редактируемой заявки:");
        String nov = input.askStr("Введите новое имя:");
        Item item = new Item(id, nov);
        if (!tracker.replace(id, item)) {
            System.out.println("Номер заявки не найден");
            System.out.println();
        }
        else {
            System.out.println(item);
            System.out.println();
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id;
        id = input.askInt("Введите номер заявки на удаление:");
        if (!tracker.delete(id)) {
            System.out.println("Номер заявки не найден");
            System.out.println();
        }
        else {
            System.out.println("Зявка с номером " + id + " успешно удалена");
            System.out.println();
        }
    }

    public static void itemById(Input input, Tracker tracker) {
        int id;
        id = input.askInt("Введите номер заявки:");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена");
            System.out.println();
        }
        else {
            System.out.println(item);
            System.out.println();
        }
    }

    public static void itemByName(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя:");
        Item[] names = tracker.findByName(name);
        if (names.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
            System.out.println();
        }
        else {
            for (Item item : names) {
                System.out.println(item);
            }
            System.out.println();
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0 :
                    StartUI.createItem(input, tracker);
                    System.out.println();
                break;
                case 1 :
                    StartUI.show(tracker);
                    break;
                case 2 :
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3 :
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4 :
                    StartUI.itemById(input, tracker);
                    break;
                case 5 :
                    StartUI.itemByName(input, tracker);
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

