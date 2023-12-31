// abstract Book class serves as a foundation for common attributes and methods among different book types
// subclasses aren’t obliged to override all methods (only the abstract ones)
public abstract class Book {
    private final String name;
    private final double value;
    private final String author;
    private final int yearPublished;
    private final String genre;
    private final int numberOfPages;

    public Book(String name, double value, String author, int yearPublished, String genre, int numberOfPages) {
        this.name = name;
        this.value = value;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    // concrete method
    // provides a default implementation that can be used by all subclasses
    public void displayTitleAndAuthor() {
        System.out.println("The book " + name + " is written by " + author);
    }

    // concrete method
    public void displayAllInformation() {
        System.out.println("Title: " + name);
        System.out.println("Author: " + author);
        System.out.println("Value: " + value);
        System.out.println("Year when published: " + yearPublished);
        System.out.println("Genre: " + genre);
        System.out.println("Total number of pages: " + numberOfPages);
    }

    // abstract method (methods without a body, similar to interfaces)
    public abstract void started();
}