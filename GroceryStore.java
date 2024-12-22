import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class GroceryStore {
    private static HashMap<Integer, Product> products = new HashMap<>();
    private static ArrayList<Product> cart = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize products
        initializeProducts();

        System.out.println("Welcome to the Online Grocery Store!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    checkout();
                    return;
                case 4:
                    System.out.println("Thank you for shopping with us! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeProducts() {
        products.put(1, new Product("Apples (1 kg)", 3.5));
        products.put(2, new Product("Bananas (1 kg)", 2.0));
        products.put(3, new Product("Carrots (1 kg)", 2.5));
        products.put(4, new Product("Milk (1 liter)", 1.5));
        products.put(5, new Product("Eggs (12 pack)", 3.0));
    }

    private static void browseProducts() {
        System.out.println("\n--- Products Available ---");
        for (int id : products.keySet()) {
            System.out.println(id + ". " + products.get(id));
        }

        System.out.print("Enter the product number to add to cart (or 0 to go back): ");
        int choice = scanner.nextInt();

        if (choice == 0) {
            return;
        }

        Product product = products.get(choice);
        if (product != null) {
            cart.add(product);
            System.out.println(product.getName() + " added to the cart.");
        } else {
            System.out.println("Invalid product number. Please try again.");
        }
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n--- Your Cart ---");
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            System.out.println((i + 1) + ". " + product);
            total += product.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty. Nothing to checkout.");
            return;
        }

        viewCart();
        System.out.println("\nProceeding to checkout...");
        System.out.println("Thank you for your purchase!");
    }
}
