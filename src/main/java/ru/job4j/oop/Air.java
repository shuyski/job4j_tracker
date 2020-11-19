package ru.job4j.oop;

public class Air implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолёт передвигается по воздуху");
    }

    @Override
    public void speed() {
        System.out.println("Средняя скорось самолёта 800 км/ч");
    }
}
