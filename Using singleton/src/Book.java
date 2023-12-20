public class Book {
    private final String name;
    private final double value;
    private final String author;
    private final int yearPublished;
    private final String genre;

    public Book(String name, double value, String author, int yearPublished, String genre) {
        this.name = name;
        this.value = value;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getGenre() {
        return genre;
    }
}