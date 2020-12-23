package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        int len = Integer.compare(left.length(), right.length());
        if (len <= 0) {
            for (int i = 0; i < left.length(); i++) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    return rsl;
                }
            }
            return left.length() - right.length();
        }
        for (int i = 0; i < right.length(); i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return right.length() - left.length();
    }
}