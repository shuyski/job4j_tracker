package ru.job4j.tracker.singleton;


import ru.job4j.tracker.Item;

public class TrackerSinglePrivateStaticFinalClass {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;


    public static TrackerSinglePrivateStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinalClass INSTANCE = new TrackerSinglePrivateStaticFinalClass();
    }

    public static void main(String[] args) {
        Item item = new Item("Name");
        System.out.println(getInstance().add(item));
    }
}