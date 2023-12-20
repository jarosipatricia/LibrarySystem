import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton - class has only one instance and provides a global access to that instance

public class BookLibrary {
    // associating each Book object with its quantity
    // Map - efficient retrieval and easy modification of quantities of a book
    // uses keys (=book objs) to store/retrieve corresponding values (=quantities)
    private final Map<Book, Integer> booksInLibrary;
    private static BookLibrary instance; // single shared instance of the class

    public BookLibrary() {
        booksInLibrary = new HashMap<>();
    }

    // static = it can be called without requiring an instance of the class
    public static BookLibrary getInstance() {
        if (instance == null) {
            instance = new BookLibrary();
        }
        return instance;
    }

    // book is present -> gets the current quantity and adds the new quantity to it
    // book is not present -> adds the book to the library with provided quantity
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

    // iterates through each Map.Entry in set got from booksInLibrary.entrySet()
    public void listBooks() {
        System.out.println("\nHere are the available books in the library:");
        for (Map.Entry<Book, Integer> entry : booksInLibrary.entrySet()) {
            System.out.println(entry.getKey().getName() + " (Copies left: " + entry.getValue() + ")");
        }
    }

    // list - cos I only want to retrieve the Book objects without their quantities
    // extract all Book objects (keys) from the Map, and return them as a List<Book>
    // creates ArrayList using constructor that takes a collection as an argument
    public List<Book> getAllBooks() {
        return new ArrayList<>(booksInLibrary.keySet());
    }
}
