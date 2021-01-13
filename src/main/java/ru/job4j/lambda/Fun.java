package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Fun {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        double rsl;
        for (int i = start; i < end; i++) {
            rsl = func.apply((double) i);
            list.add(rsl);
        }
        return list;
    }
}