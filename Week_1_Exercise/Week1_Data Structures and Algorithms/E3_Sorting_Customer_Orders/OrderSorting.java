
import java.util.Arrays;
import java.util.Scanner;

public class OrderSorting {
    private static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    private Order[] orders;
    private Scanner scanner;

    public OrderSorting() {
        scanner = new Scanner(System.in);
        initializeOrders();
    }

    private void initializeOrders() {
        orders = new Order[]{
            new Order(1, "Sam", 150.50),
            new Order(2, "Asish", 75.25),
            new Order(3, "Dilpreet", 220.00),
            new Order(4, "Anwar", 50.75),
            new Order(5, "Taylor", 180.30)
        };
    }

    private void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    //swapping
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (or pivot)
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void printOrders(Order[] arr) {
        for (Order order : arr) {
            System.out.println(order);
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nOrder Sorting System");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Print Current Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Order[] bubbleSortArray = orders.clone();
                    bubbleSort(bubbleSortArray);
                    System.out.println("Orders sorted using Bubble Sort:");
                    printOrders(bubbleSortArray);
                    break;
                case 2:
                    Order[] quickSortArray = orders.clone();
                    quickSort(quickSortArray, 0, quickSortArray.length - 1);
                    System.out.println("Orders sorted using Quick Sort:");
                    printOrders(quickSortArray);
                    break;
                case 3:
                    System.out.println("Current Orders:");
                    printOrders(orders);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        OrderSorting sortingSystem = new OrderSorting();
        sortingSystem.run();
    }
}