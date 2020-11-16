package ru.job4j.tracker;


public class StartUI {

    public static void main(String[] args) {
        Tracker zayavka = new Tracker();
        zayavka.add(new Item(12,"First"));
        zayavka.add(new Item(23,"Second"));
        zayavka.add(new Item(15,"Third"));
        Item n = zayavka.findById(1);
        System.out.println(n);

    }
}

