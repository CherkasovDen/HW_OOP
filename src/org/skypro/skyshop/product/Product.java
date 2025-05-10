package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        this.nameProduct = nameProduct;

    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }
    @Override
    public String getContentType() {
        return "PRODUCT";
    }


}


