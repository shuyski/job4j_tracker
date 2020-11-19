package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void speed() {
        System.out.println("Средняя скорось автобуса 80 км/ч");
    }

    @Override
    public void move() {
        System.out.println("Автобус едет по дороге");
    }
}
