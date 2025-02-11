// Problem 1: Smart Warehouse Management System
package smart_warehouse_management;
import java.util.*;

// Abstract class representing an item in the warehouse
abstract class WarehouseItem {
    String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}

// Different types of warehouse items
class Electronics extends WarehouseItem {
    public Electronics(String name) { super(name); }
}
class Groceries extends WarehouseItem {
    public Groceries(String name) { super(name); }
}
class Furniture extends WarehouseItem {
    public Furniture(String name) { super(name); }
}

// Generic storage class for warehouse items
class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public List<T> getItems() { return items; }
    // Displays all items in storage
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}

public class WarehouseManagement {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        Storage.displayItems(electronicsStorage.getItems());
    }
}