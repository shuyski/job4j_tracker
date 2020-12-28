package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1o = o1.split("/");
        String[] o2o = o2.split("/");
        if (!(o1o[0].compareTo(o2o[0]) == 0)) {
            return o1o[0].compareTo(o2o[0]);
        }
        for (int i = 1; i < Math.min(o1o.length, o2o.length); i++) {
            if (!((o2o[i].compareTo(o1o[i])) == 0)) {
                return o1o[i].compareTo(o2o[i]);
            }
        }
       return Integer.compare(o1o.length, o2o.length);
    }
}