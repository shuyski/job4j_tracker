package ru.job4j.pojo;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Шуйский Руслан, ");
        student.setGroup(104);
        student.setDate("01-09-2020 ");
        System.out.println(student.getFio()
                + "группа: " + student.getGroup()
                + ","
                + " Дата зачисления: " + student.getDate()
        );
    }
}
