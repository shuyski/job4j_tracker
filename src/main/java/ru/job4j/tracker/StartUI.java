package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0 :
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
                    System.out.println("Введите номер редактируемой заявки:");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.println("Введите новое имя:");
                    String nov = String.valueOf(scanner.nextLine());
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
                    System.out.println("Введите номер заявки на удаление:");
                    id = Integer.valueOf(scanner.nextLine());
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
                    System.out.println("Введите номер заявки:");
                    id = Integer.valueOf(scanner.nextLine());
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
                    System.out.println("Введите имя:");
                    name = String.valueOf(scanner.nextLine());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

