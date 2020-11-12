package ru.job4j.oop;

public class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        LiquidationProduct lProduct = off("Oil", 10);
        System.out.println(lProduct.label());
    }

    public static Product of(String name, int price) {
        return new Product(name, price);
    }

    public static LiquidationProduct off(String name, int price) {
        return new LiquidationProduct(name, price);
    }
}
