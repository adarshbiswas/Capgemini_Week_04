package shopping_carts;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedItems = new TreeMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
            sortedItems.put(productPrices.get(product), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void viewCart() {
        System.out.println("\nCart (Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " (Qty: " + entry.getValue() + ")");
        }
    }

    public void viewSortedByPrice() {
        System.out.println("\nCart (Sorted by Price):");
        for (Map.Entry<Double, String> entry : sortedItems.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to catalog
        cart.addProduct("Laptop", 1000.0);
        cart.addProduct("Headphones", 200.0);
        cart.addProduct("Mouse", 50.0);
        cart.addProduct("Keyboard", 80.0);

        // Adding items to the shopping cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Keyboard", 1);
        cart.addToCart("Headphones", 1);

        // Viewing the cart in order of addition
        cart.viewCart();

        // Viewing the cart sorted by price
        cart.viewSortedByPrice();
    }
}
