public class Main {
    public static void main(String[] args) {
        BookLibrary library = BookLibrary.getInstance();

        // TODO - do you think these books are the same?
        AudioBook audioBook1 = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 77, 1.6, "Some Famous Reader");
        AudioBook audioBook2 = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 77, 1.6, "Some Famous Reader");

        // TODO - and what about these?
        SignedBook signedBook1 = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi", 100);
        SignedBook signedBook2 = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi", 100);

        // TODO - what happens if I register books to the library this way And how to solve it?
        library.registerBook(audioBook1, 2);
        library.registerBook(audioBook2, 3);
        library.registerBook(signedBook1, 2);
        library.registerBook(signedBook2, 5);

        Librarian librarian = new Librarian(library);
        librarian.interactWithUser();
    }
}
