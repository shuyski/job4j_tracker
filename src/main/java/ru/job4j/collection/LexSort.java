package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lef = left.split(". ");
        String[] rig = right.split(". ");
        int i = Integer.parseInt(lef[0]);
        int j = Integer.parseInt(rig[0]);
        return Integer.compare(i, j);
    }
}