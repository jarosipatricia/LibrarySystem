class AudioBook extends Book {
    private final double duration;
    private final String reader;

    public AudioBook(String name, double value, String author, int yearPublished, String genre, double duration,
            String reader) {
        super(name, value, author, yearPublished, genre);
        this.duration = duration;
        this.reader = reader;
    }

    public double getDuration() {
        return this.duration;
    }

    public String getReader() {
        return this.reader;
    }
}