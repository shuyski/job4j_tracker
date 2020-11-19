package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void speed() {
        System.out.println("Средняя скорось поезда 150 км/ч");
    }

    @Override
    public void move() {
        System.out.println("Поезд движется по рельсам");
    }
}
