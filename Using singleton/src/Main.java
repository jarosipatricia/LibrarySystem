public class Main {
    public static void main(String[] args) {
        // instead of new BookLibrary(); utilize Singleton instance
        BookLibrary library = BookLibrary.getInstance();

        Book basicBook = new Book("Book1", 20.0, "Author1", 2018, "Fiction");
        AudioBook audioBook = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 2, "Some Famous Reader");
        SignedBook signedBook = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi");

        library.registerBook(basicBook, 3);
        library.registerBook(audioBook, 6);
        library.registerBook(signedBook, 1);

        Librarian librarian = new Librarian(library);
        librarian.interactWithUser();
    }
}
