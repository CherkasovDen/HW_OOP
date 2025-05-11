package org.skypro.skyshop;

import java.util.Arrays;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.BestResultNotFound;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 150);
        Product milk = new SimpleProduct("Молоко", 82);
        Product bread = new DiscountedProduct("Хлеб", 70, 30);
        Product bananas = new SimpleProduct("Бананы", 150);
        Product potato = new FixPriceProduct("Картофель");
        Product meat = new SimpleProduct("Мясо", 400);

        ProductBasket bas1 = new ProductBasket();

        bas1.addProduct(apple);
        bas1.addProduct(milk);
        bas1.addProduct(bread);
        bas1.addProduct(bananas);
        bas1.addProduct(potato);

        System.out.println("Добавление 6го продукта в корзину");
        bas1.addProduct(meat);
        System.out.println(" ");


        System.out.println("Общая стоимость корзины: " + bas1.getTotalPrice());
        System.out.println(" ");


        System.out.println("Содержимое корзины");
        bas1.printBasket();
        System.out.println(" ");


        System.out.println("Поиск товара, который есть в корзине");
        System.out.println("В корзине есть 'Яблоко': " + bas1.checkProduct("Яблоко"));
        System.out.println("Поиск товара, которого нет в корзине.");
        System.out.println("В корзине есть 'Греча': " + bas1.checkProduct("Греча"));
        System.out.println(" ");

        System.out.println("Очистка корзины.");
        bas1.clearBasket();

        bas1.printBasket();
        System.out.println("Общая стоимость корзины: " + bas1.getTotalPrice());
        System.out.println("В корзине есть 'Яблоко': " + bas1.checkProduct("Яблоко"));

        SearchEngine searchEngine = new SearchEngine(12);
        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(bread);
        searchEngine.add(bananas);
        searchEngine.add(potato);
        searchEngine.add(meat);


        Article article1 = new Article("телефон", "инструкция к телефону");
        Article article2 = new Article("нивелир", "руководство пользователя");
        Article article3 = new Article("перфоратор", "руководство по эксплуатации");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println(" ");


        System.out.println(Arrays.toString(searchEngine.search("Мясо")));
        System.out.println(Arrays.toString(searchEngine.search("телефон")));
        System.out.println(Arrays.toString(searchEngine.search("перфоратор")));

        System.out.println(" ");
        System.out.println("Исключения");
        //Product plum = new SimpleProduct("Слива", -82);
        //Product tea = new DiscountedProduct("Чай", 90, -30);

        try {
            Product plum = new SimpleProduct("   ", 82);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        try {
            Product oil = new SimpleProduct("Масло", -82);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        try {
            Product lemon = new DiscountedProduct("Лемон", -32, 150);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        try {
            Product Ice = new DiscountedProduct("Лед", 82, 150);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }


        System.out.println(" ");
        System.out.println("BestResultNotFound");
        try {
            Searchable result = searchEngine.findBestMatch(" Барабан");
            System.out.println("Найдено: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }

    }
}