public class Main {
    public static void main(String[] args) {
        BookLibrary library = BookLibrary.getInstance();

        AudioBook audioBook = new AudioBook("Book3", 10.5, "Author3", 1999, "Scifi", 77, 1.6, "Some Famous Reader");
        SignedBook signedBook = new SignedBook("Book4", 16.5, "Author3", 2022, "Scifi", 100);

        library.registerBook(audioBook, 6);
        library.registerBook(signedBook, 1);

        signedBook.started();
        signedBook.getReadingStatus(50);
        signedBook.stoppedAt(51);

        audioBook.started();
        audioBook.getReadingStatus(30);
        audioBook.stoppedAt(70);

        audioBook.displayTitleAndAuthor();
        audioBook.displayAllInformation();

        library.registerBook(audioBook, 6);
        library.registerBook(signedBook, 1);

        Librarian librarian = new Librarian(library);
        librarian.interactWithUser();
    }
}
