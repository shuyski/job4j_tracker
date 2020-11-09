package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;


public class StartUI {

    public static void main(String[] args) {
       DateTimeFormatter item = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String datatime = Item.getCreated().format(item);
        System.out.println("Сегодня: " + datatime);
    }
}
