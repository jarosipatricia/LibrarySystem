public class Book {
    private final String name;
    private final double value;
    private final String author;
    private final int yearPublished;
    private final String genre;

    // ? - represents an unspecified type
    // constructor accepts any type of Builder (Book.Builder, EBook.EBookBuilder,..)
    protected Book(Builder<?> builder) {
        this.name = builder.name;
        this.value = builder.value;
        this.author = builder.author;
        this.yearPublished = builder.yearPublished;
        this.genre = builder.genre;
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

    // T represents a specific builder type
    // ensures that methods return correct type of builder, enabling method chaining
    // indicates that Builder class is designed to work with subclasses of itself
    public static class Builder<T extends Builder<T>> {
        private final String name;
        private double value;
        private String author;
        private int yearPublished;
        private String genre;

        public Builder(String name) {
            this.name = name;
        }

        // return current instance of builder casted to generic type T
        // allows method chaining by ensuring correct builder type
        protected T self() {
            return (T) this;
        }

        public T setValue(double value) {
            this.value = value;
            return self();
        }

        public T setAuthor(String author) {
            this.author = author;
            return self();
        }

        public T setYearPublished(int yearPublished) {
            this.yearPublished = yearPublished;
            return self();
        }

        public T setGenre(String genre) {
            this.genre = genre;
            return self();
        }

        public Book build() {
            return new Book(this);
        }
    }
}
