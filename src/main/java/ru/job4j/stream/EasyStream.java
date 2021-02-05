package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    public EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> listMap = new ArrayList<>();
        for (Integer in : list) {
            listMap.add(fun.apply(in));
        }
        return new EasyStream(listMap);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> listMap = new ArrayList<>();
        for (Integer in : list) {
            if (fun.test(in)) {
                listMap.add(in);
            }
        }
        return new EasyStream(listMap);
    }

    public List<Integer> collect() {
        return list;
    }
}