package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        if (products[0] == null) {
            products[0] = products[1];
            products[1] = null;
            return products;
        }
        return products;
    }
}
