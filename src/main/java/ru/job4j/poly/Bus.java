package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Можно ехать");
    }

    @Override
    public void count(int passen) {
        System.out.println(passen);
    }

    @Override
    public int price(int fuel) {
        int rsl = fuel * 45;
        return rsl;
    }
}
