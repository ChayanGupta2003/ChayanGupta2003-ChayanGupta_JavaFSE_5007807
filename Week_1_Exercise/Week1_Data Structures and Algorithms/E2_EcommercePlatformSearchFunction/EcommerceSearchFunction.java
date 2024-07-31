
import java.util.Arrays;
import java.util.Scanner;

public class EcommerceSearchFunction {
    private static class Product implements Comparable<Product> {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Product other) {
            return this.productName.compareTo(other.productName);
        }
    }

    private Product[] products;
    private Scanner scanner;

    public EcommerceSearchFunction() {
        scanner = new Scanner(System.in);
        initializeProducts();
    }

    private void initializeProducts() {
        products = new Product[]{
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Headphones", "Electronics"),
            new Product(4, "T-shirt", "Clothing"),
            new Product(5, "Jeans", "Clothing"),
            new Product(6, "Sneakers", "Footwear"),
            new Product(7, "Watch", "Accessories"),
            new Product(8, "Backpack", "Accessories"),
            new Product(9, "Book", "Books"),
            new Product(10, "Tablet", "Electronics")
        };
        Arrays.sort(products); 
    }

    private Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private Product binarySearch(String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = productName.compareToIgnoreCase(products[mid].productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    public void start() {
        while (true) {
            System.out.println("\nE-commerce Platform Search Function");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 3) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            System.out.print("Enter product name to search: ");
            String productName = scanner.nextLine();

            Product result;
            long startTime = System.nanoTime();

            switch (choice) {
                case 1:
                    result = linearSearch(productName);
                    break;
                case 2:
                    result = binarySearch(productName);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            if (result != null) {
                System.out.println("Product found: " + result);
            } else {
                System.out.println("Product not found.");
            }

            System.out.println("Search time: " + duration + " nanoseconds");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        EcommerceSearchFunction obj = new EcommerceSearchFunction();
        obj.start();
    }
}