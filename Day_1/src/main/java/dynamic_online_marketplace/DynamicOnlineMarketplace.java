// Problem 2: Dynamic Online Marketplace
package dynamic_online_marketplace;

import static dynamic_online_marketplace.Marketplace.applyDiscount;

// Abstract class representing a product
abstract class Product {
    String name;
    double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

// Different types of products
class Book extends Product {
    public Book(String name, double price) { super(name, price); }
}
class Clothing extends Product {
    public Clothing(String name, double price) { super(name, price); }
}

class Marketplace {
    // Generic method to apply discount on a product
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", 500);
        applyDiscount(book, 10);
        System.out.println("Discounted Price: " + book.getPrice());
    }
}
