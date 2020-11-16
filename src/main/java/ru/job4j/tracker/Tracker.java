package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] namesId = new Item[items.length];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                namesId[j] = items[i];
                j++;
            }
        }
        namesId = Arrays.copyOf(namesId, j);
        return namesId;
    }

    public String[] findByName(String key) {
        String[] names = new String[items.length];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() == key) {
                names[j] = items[i].getName();
            }
        }
        names = Arrays.copyOf(names, j);
        return names;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}