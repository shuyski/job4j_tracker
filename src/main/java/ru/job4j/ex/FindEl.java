package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Not found");
    }

    public static void main(String[] args) {
        String[] qw = {"qwe", "qwe1", "qwe2"};
        try {
            int s = indexOf(qw, "qwe3");
            System.out.println(s);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
