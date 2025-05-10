package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

public class DiscountedProduct extends Product
{
    private int basePrice;
    private int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }


    @Override
    public String toString() {
        return getNameProduct() + ": " + getPrice() + " (с учетом скидки " + discount + " %)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}
