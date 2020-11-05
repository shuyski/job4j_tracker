package ru.job4j.tracker.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNike(String nike) {
        this.name = nike;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNike("Gav");
        gav.show();
        System.out.println("There are black's food");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNike("Black cat");
        black.show();
    }
}
