package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingleEnum {
    INSTANCE;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public static void main(String[] args) {
        Item item = new Item("Name");
        System.out.println(INSTANCE.add(item));
    }
}
