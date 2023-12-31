import java.util.Scanner;
import java.util.function.Consumer;

public class Librarian {
    // allows the Librarian object to interact with a single instance of BookLibrary
    private final BookLibrary bookLibrary;
    private Scanner scanner = new Scanner(System.in);

    // another solution for reducing runtime errors caused by incorrect string usage
    // in interactWithUser -> handleBookAction(BookAction.BORROW);
    // in handleBookAction -> action == BookAction.BORROW
    public enum BookAction {
        BORROW,
        RETURN
    }

    public Librarian(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public void interactWithUser() {
        while (true) {
            System.out.println("\nChoose an action from one of the options:");
            System.out.println("1. List books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consumes the newline character

            switch (choice) {
                case 1:
                    bookLibrary.listBooks();
                    break;
                case 2:
                    // lambda expressions are used to perform the borrow or return actions
                    // directly apply the actions on book using functional interface
                    handleBookAction(book -> bookLibrary.borrowBook(book));
                    break;
                case 3:
                    handleBookAction(book -> bookLibrary.returnBook(book));
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    // Consumer is a functional interface, represents an operation that takes a
    // single input argument
    // Consumer<Book> represents an action to be performed on a book
    private void handleBookAction(Consumer<Book> action) {
        boolean matchFound = false;
        System.out.print("Enter the title of the book: ");
        String bookTitle = scanner.nextLine();

        for (Book book : bookLibrary.getAllBooks()) {
            if (book.getName().equalsIgnoreCase(bookTitle)) { // case-insensitive comparison
                matchFound = true;
                action.accept(book);
                break; // Exit loop if a match is found
            }
        }

        if (!matchFound) {
            System.out.println("Book was not found in the library.");
        }
    }
}
