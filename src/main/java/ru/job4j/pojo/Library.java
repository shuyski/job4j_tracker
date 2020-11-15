package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("Java", 150);
        Book two = new Book("C++", 300);
        Book three = new Book("Python", 123);
        Book four = new Book("Clean code", 50);
        Book[] mas = new Book[4];
        mas[0] = one;
        mas[1] = two;
        mas[2] = three;
        mas[3] = four;
        for (int index = 0; index < mas.length; index++) {
            System.out.println(mas[index].getName() + " " + mas[index].getCount());
        }
        System.out.println();
        Book i = mas[0];
        mas[0] = mas[3];
        mas[3] = i;
        for (int index = 0; index < mas.length; index++) {
            System.out.println(mas[index].getName() + " " + mas[index].getCount());
        }
        System.out.println();
        for (int index = 0; index < mas.length; index++) {
            if (mas[index].getName().equals("Clean code")) {
                System.out.println(mas[index].getName() + " " + mas[index].getCount());
            }
        }

    }
}
