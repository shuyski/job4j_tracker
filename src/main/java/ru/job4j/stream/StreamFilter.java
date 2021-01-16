package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {
        ArrayList<Integer> alist = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            alist.add((int) (Math.random() * 10) - 4);
        }
        List<Integer> list = alist.stream().filter(
                lis -> (lis > 0)).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
