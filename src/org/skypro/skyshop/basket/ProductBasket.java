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
        return productsBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }


    public void printBasket() {
        boolean isEmpty = productsBasket.values().stream()
                .flatMap(Collection::stream)
                .findAny()
                .isEmpty();

        if (isEmpty) {
            System.out.println("В корзине пусто.");
            return;
        }
        productsBasket.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.toString()));

        int specialCount = getSpecialCount();

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);

    }

    private int getSpecialCount() {
        return (int) productsBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
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
        return removedProducts;
    }
}

