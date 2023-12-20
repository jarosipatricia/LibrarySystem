import java.util.Scanner;

public class Librarian {
    // allows the Librarian object to interact with a single instance of BookLibrary
    private final BookLibrary bookLibrary;
    private Scanner scanner = new Scanner(System.in);

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
                    handleBookAction("borrow");
                    break;
                case 3:
                    handleBookAction("return");
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

    private void handleBookAction(String action) {
        boolean matchFound = false;
        System.out.print("Enter the title of the book you want to " + action + ": ");
        String bookTitle = scanner.nextLine();

        for (Book book : bookLibrary.getAllBooks()) {
            if (book.getName().equalsIgnoreCase(bookTitle)) { // case-insensitive comparison
                matchFound = true;
                if (action.equals("borrow")) {
                    bookLibrary.borrowBook(book);
                } else if (action.equals("return")) {
                    bookLibrary.returnBook(book);
                }
                break; // Exit loop if a match is found
            }
        }

        if (!matchFound) {
            System.out.println("Book was not found in the library.");
        }
    }
}
