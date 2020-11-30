package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleStaticFiled {
    private static TrackerSingleStaticFiled instance;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;


    private TrackerSingleStaticFiled() {
    }

    public static TrackerSingleStaticFiled getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticFiled();
        }
        return instance;
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
