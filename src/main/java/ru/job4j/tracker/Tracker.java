package ru.job4j.tracker;


import java.util.ArrayList;


public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(items.size(), item);
        return item;
    }

    public ArrayList<Item> findAll() {

        return (ArrayList<Item>) items.clone();
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> names = new ArrayList<>();
        for (Item name : items) {
            if (name.getName().contains(key)) {
                names.add(name);
            }
        }
        return names;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
        item.setId(id);
        items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        items.remove(index);
        return rsl;
    }
}