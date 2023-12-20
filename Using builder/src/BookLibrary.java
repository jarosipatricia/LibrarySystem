import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    private final Map<Book, Integer> booksInLibrary;
    private static BookLibrary instance;

    public BookLibrary() {
        booksInLibrary = new HashMap<>();
    }

    public static BookLibrary getInstance() {
        if (instance == null) {
            instance = new BookLibrary();
        }
        return instance;
    }

    public void registerBook(Book book, int quantity) {
        booksInLibrary.put(book, booksInLibrary.getOrDefault(book, 0) + quantity);
    }

    public void borrowBook(Book book) {
        if (booksInLibrary.containsKey(book)) {
            int quantity = booksInLibrary.get(book);
            if (quantity > 0) {
                booksInLibrary.put(book, quantity - 1);
                System.out.println("You have borrowed: " + book.getName());
            } else {
                System.out.println("Sorry, but no more copies are available for this book.");
            }
        } else {
            System.out.println("Sorry, but we don't have this book in the library.");
        }
    }

    public void returnBook(Book book) {
        booksInLibrary.put(book, booksInLibrary.getOrDefault(book, 0) + 1);
        System.out.println("You have returned: " + book.getName());
    }

    public void listBooks() {
        System.out.println("\nHere are the available books in the library:");
        for (Map.Entry<Book, Integer> entry : booksInLibrary.entrySet()) {
            System.out.println(entry.getKey().getName() + " (Copies left: " + entry.getValue() + ")");
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(booksInLibrary.keySet());
    }
}
