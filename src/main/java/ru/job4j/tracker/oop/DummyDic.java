package ru.job4j.tracker.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic eng = new DummyDic();
        String slv = "Question";
        System.out.println(eng.engToRus(slv));
    }
}
