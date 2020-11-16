package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        products[index] = null;
        for (int i = 1; i < products.length; i++) {
            if (products[i] != null)  {
                products[i - 1] = products[i];
                products[i] = null;
                return products;
            }


        }
        return products;
    }
}
