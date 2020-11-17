package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static boolean check(int check) {
        int[] array = {1, 2, 3};
        for (int i = 0; i < array.length; i++) {
            if (check == array[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String win = "Второй игрок";
        int count = 11;
        do {
           int one = 0;
           int two = 0;
            do {
                System.out.print("Первый игрок" + System.lineSeparator()
                        + "Введите число от 1 до 3:");
                one = input.nextInt();
            } while (!check(one));
            count = count - one;
            System.out.println("Осталось спичек: " + count);
            System.out.println();
            if (count <= 0) {
                win = "Первый игрок";
                break;
            }
            do {
                System.out.print("Второй игрок" + System.lineSeparator()
                        + "Введите число от 1 до 3:");
                two = input.nextInt();
            } while (!check(two));
            count = count - two;
            System.out.println("Осталось спичек: " + count);
            System.out.println();
        } while (count > 0);
        System.out.println("Игра окончена. Победил: " + win);
    }
}
