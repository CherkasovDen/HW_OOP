package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.SearchEngine;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 113;


    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getSearchTerm () {
        return getNameProduct();
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}
