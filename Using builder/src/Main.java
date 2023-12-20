public class Main {
        public static void main(String[] args) {
                BookLibrary library = BookLibrary.getInstance();

                Book book = new Book.Builder("Book")
                                .setValue(22.5)
                                .setAuthor("Book Author")
                                .setYearPublished(2021)
                                .setGenre("Fiction")
                                .build();

                AudioBook audioBook = new AudioBook.AudioBookBuilder("Audiobook")
                                .setValue(13.70)
                                .setAuthor("Book Author")
                                .setYearPublished(2021)
                                .setGenre("Romantic")
                                .setDuration(2)
                                .setReader("Some famous reader")
                                .build();

                SignedBook signedBook = new SignedBook.SignedBookBuilder("Signedbook")
                                .setValue(22.5)
                                .setAuthor("Book Author")
                                .setYearPublished(2021)
                                .setGenre("Fiction")
                                .build();

                library.registerBook(book, 3);
                library.registerBook(audioBook, 6);
                library.registerBook(signedBook, 1);

                Librarian librarian = new Librarian(library);
                librarian.interactWithUser();
        }
}