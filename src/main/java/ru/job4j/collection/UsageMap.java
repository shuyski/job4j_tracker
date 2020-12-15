package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ryslan@mail.ru", "Иванов Руслан Иванович");
        map.put("rys@mail.ru", "Иванов Иван Иванович");
        map.put("ruslan@mail.ru", "Петров Андрей Иванович");
        map.put("lan@mail.ru", "Смирнов Кирилл Иванович");
        for (String key : map.keySet()) {
            System.out.println(map.get(key) + "    " + key);
        }
    }
}
