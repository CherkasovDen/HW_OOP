package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] productsBasket = new Product[5];


    public void addProduct(Product product) {
        for (int i = 0; i < productsBasket.length; i++) {
            if (productsBasket[i] == null) {
                productsBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт.");
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
        for (int i = 0; i < productsBasket.length; i++) {
            productsBasket[i] = null;
        }
    }


}
