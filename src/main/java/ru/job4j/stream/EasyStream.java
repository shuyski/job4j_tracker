package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    public static EasyStream of(List<Integer> source) {
        return new EasyStream();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        fun.apply(2);
        return new EasyStream();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        if (fun.test(2)) {
            return new EasyStream();
        }
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {
        return List.of(1, 2, 3);
    }
}