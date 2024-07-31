
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Product> products;
    private Scanner scanner;

    public Inventory() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }

    public void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        
        Product product = new Product(id, name, quantity, price);
        products.add(product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int updateId = scanner.nextInt();
        System.out.print("Enter new Quantity: ");
        int newQuantity = scanner.nextInt();
        System.out.print("Enter new Price: ");
        double newPrice = scanner.nextDouble();

        for (Product product : products) {
            if (product.productId == updateId) {
                product.quantity = newQuantity;
                product.price = newPrice;
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product not found with ID: " + updateId);
    }

    public void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int deleteId = scanner.nextInt();
        products.removeIf(product -> product.productId == deleteId);
        System.out.println("Product deleted with ID: " + deleteId);
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Inventory obj = new Inventory();
        obj.run();
    }
}