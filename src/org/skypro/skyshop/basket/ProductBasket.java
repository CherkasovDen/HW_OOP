package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> productsBasket = new ArrayList<>();


    public void addProduct(Product product) {
        productsBasket.add(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : productsBasket) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int specialCount = 0;
        for (Product product : productsBasket) {
            if (product != null) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто.");
            return;
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProduct(String nameProduct) {
        for (Product product : productsBasket) {
            if (product != null && product.getNameProduct().equals(nameProduct)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        productsBasket.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = productsBasket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getNameProduct().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}
