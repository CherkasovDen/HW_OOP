package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Необходимо вести название продукта!!!");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return getNameProduct().equals(product.getNameProduct());
    }

    @Override
    public int hashCode() {
        return getNameProduct().hashCode();
    }

}


