package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsBasket = new HashMap<>();


    public void addProduct(Product product) {
        String name = product.getNameProduct();
        productsBasket.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (List<Product> productList : productsBasket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int specialCount = 0;
        for (List<Product> productList : productsBasket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                    isEmpty = false;
                }
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
        return productsBasket.containsKey(nameProduct);
    }

    public void clearBasket() {
        productsBasket.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        List<Product> products = productsBasket.get(name);
        if (products != null) {
            removedProducts.addAll(products);
            productsBasket.remove(name);
        }
//return productsBasket.remove(name);
        return removedProducts;
    }
}
