package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;


public class StartUI {

    public static void main(String[] args) {
       DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
       Item item = new Item();
       String datatime = item.getCreated().format(date);
       System.out.println("Сегодня: " + datatime);
    }
}
