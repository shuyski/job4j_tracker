package ru.job4j.collection;

import java.util.Comparator;


public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Integer.compare(left.length(), right.length());
        switch (len) {
            case 0:
                for (int i = 0; i < left.length(); i++) {
                    rsl = rsl + Character.compare(left.charAt(i), right.charAt(i));
                }
                return rsl;
            case -1:
                for (int i = 0; i < left.length(); i++) {
                    rsl = rsl + Character.compare(left.charAt(i), right.charAt(i));
                }
                if (rsl == 0) {
                    for (int i = left.length(); i < right.length(); i++) {
                    rsl = rsl + Character.compare(' ', right.charAt(i));
                    }
                }
                return rsl;
        }
                for (int i = 0; i < right.length(); i++) {
                    rsl = rsl + Character.compare(left.charAt(i), right.charAt(i));
                }
                if (rsl == 0) {
                    for (int i = right.length(); i < left.length(); i++) {
                    rsl = rsl + Character.compare(left.charAt(i), ' ');
                    }
                }
                return rsl;
        }
}

