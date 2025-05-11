package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0!!!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}

