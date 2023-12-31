public class Main {
    public static void main(String[] args) {
        BookLibrary library = BookLibrary.getInstance();

        // equals method is overridden to compare respective fields for equality
        // in this example these books are the same so only the quantity will be updated
        // when registering them
        // if I change one of the values, the book will be registered as a new one
        AudioBook audioBook1 = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 77, 1.6, "Some Famous Reader");
        AudioBook audioBook2 = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 77, 1.6, "Some Famous Reader");

        // same here
        SignedBook signedBook1 = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi", 100);
        SignedBook signedBook2 = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi", 100);

        library.registerBook(audioBook1, 2);
        library.registerBook(audioBook2, 3);
        library.registerBook(signedBook1, 2);
        library.registerBook(signedBook2, 5);

        Librarian librarian = new Librarian(library);
        librarian.interactWithUser();
    }
}
