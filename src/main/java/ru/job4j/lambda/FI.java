package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] att = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare -  " + right.getSize() + " : " + left.getSize());
                return Integer.compare(left.getSize(), right.getSize());
        };
        Arrays.sort(att, comparator);
    }
}