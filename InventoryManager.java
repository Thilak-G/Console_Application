import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class InventoryManager {

    private static ArrayList<Item> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Search Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewItems();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Exiting Inventory Management System. Goodbye!");
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Item item = new Item(name, quantity, price);
        inventory.add(item);
        System.out.println("Item added successfully!");
    }

    private static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            System.out.println("Current Inventory:");
            for (Item item : inventory) {
                System.out.println(item);
            }
        }
    }

    private static void searchItem() {
        System.out.print("Enter item name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Item found: " + item);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    private static void deleteItem() {
        System.out.print("Enter item name to delete: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                inventory.remove(item);
                System.out.println("Item deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }
}
