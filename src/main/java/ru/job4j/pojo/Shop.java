package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] product) {
       for (int index = 0; index < product.length; index++) {
            if (product[index] == null) {
                return index;
            }
        }
        return -1;
    }
}
