package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleStaticFinalField {
    private static final TrackerSingleStaticFinalField INSTANCE = new TrackerSingleStaticFinalField();
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private TrackerSingleStaticFinalField() {
    }

    public static TrackerSingleStaticFinalField getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public static void main(String[] args) {
        Item item = new Item("Name");
        System.out.println(getInstance().add(item));
    }
}