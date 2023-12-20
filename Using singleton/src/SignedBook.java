public class SignedBook extends Book {

    public SignedBook(String name, double value, String author, int yearPublished, String genre) {
        super(name, value * 2, author, yearPublished, genre);
    }
}
