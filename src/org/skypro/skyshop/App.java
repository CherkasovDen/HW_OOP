package org.skypro.skyshop;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
        Product apple = new SimpleProduct("Яблоко Гала", 150);
        Product apple1 = new SimpleProduct("Яблоко Голден", 250);
        Product apple2 = new SimpleProduct("Яблоко Спартан", 350);
        Product apple3 = new SimpleProduct("Яблоко Фуджи", 450);
        Product apple4 = new SimpleProduct("Яблоко Глостер", 550);
        Product apple5 = new SimpleProduct("Яблоко Ренет", 650);

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


        System.out.println("\nСоздание объекта SearchEngine");

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(apple);
        searchEngine.add(milk);
        searchEngine.add(bread);
        searchEngine.add(bananas);
        searchEngine.add(potato);
        searchEngine.add(meat);
        searchEngine.add(bananas);

        searchEngine.add(apple1);
        searchEngine.add(apple2);
        searchEngine.add(apple3);
        searchEngine.add(apple4);
        searchEngine.add(apple5);


        Article article1 = new Article("телефон", "инструкция к телефону ");
        Article article2 = new Article("нивелир", "руководство пользователя");
        Article article3 = new Article("перфоратор", "руководство по эксплуатации");

        Article article11 = new Article("Яблоко1", "приготовление джема");
        Article article12 = new Article("Яблоко123", "приготовление варенья");


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article11);
        searchEngine.add(article12);

        System.out.println(searchEngine.search("Мясо"));

        System.out.println("\nИсключения");

        try {
            Product plum = new SimpleProduct("   ", 82);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
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


        System.out.println(" ");
        System.out.println("Коллеции");


        ProductBasket bas2 = new ProductBasket();
        bas2.addProduct(apple);
        bas2.addProduct(milk);
        bas2.addProduct(bread);
        bas2.addProduct(bananas);
        bas2.addProduct(potato);

        System.out.println("Содержимое корзины №2 до удаления");
        bas2.printBasket();

        List<Product> removed = bas2.removeProductsByName("Яблоко");
        System.out.println("\nУдаленные продукты:");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removed) {
                System.out.println(p);
            }
        }
        System.out.println("\nСодержимое корзины №2 после удаления");
        bas2.printBasket();

        System.out.println("\nУдаления не существующего продукта");
        List<Product> removedNonExist = bas2.removeProductsByName("Чай");
        System.out.println("\nУдаленные продукты:");
        if (removedNonExist.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removedNonExist) {
                System.out.println(p);
            }
        }
        System.out.println("Содержимое корзины №2 после удаления не существующего продукта");
        bas2.printBasket();

        System.out.println("\nРезультаты поиска сортируются в соответствии с этим компаратором");
        Set<Searchable> results = searchEngine.search("Яблоко");

        System.out.println("Результаты поиска:");
        for (Searchable item : results) {
            System.out.println(item);
        }

    }
}