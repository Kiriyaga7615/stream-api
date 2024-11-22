package app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> categoryAverages = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Результат: " + categoryAverages);

        categoryAverages.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Категорія з найвищою середньою ціною: " + entry.getKey() + " (Середня ціна: " + entry.getValue() + ")"));
    }
}
