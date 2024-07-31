
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    static Book linearSearch(ArrayList<Book> books, String searchTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                return book;
            }
        }
        return null;
    }

    static Book binarySearch(ArrayList<Book> books, String searchTitle) {
        int left = 0;
        int right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(searchTitle);
            if (cmp == 0) {
                return books.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", "J.K Rowling"));
        books.add(new Book(2, "Theory of Everything", "Professor Stephen Hawking"));
        books.add(new Book(3, "Macbeth", "William Shakespeare"));

        Collections.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title to search:");
        String searchTitle = scanner.nextLine();

        Book linearResult = linearSearch(books, searchTitle);
        Book binaryResult = binarySearch(books, searchTitle);

        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult.title + " by " + linearResult.author : "Not found"));
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult.title + " by " + binaryResult.author : "Not found"));
    }
}
