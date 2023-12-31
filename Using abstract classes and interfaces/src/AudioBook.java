import java.util.Objects;

class AudioBook extends Book implements Readable {
    private final double duration;
    private final String reader;

    public AudioBook(String name, double value, String author, int yearPublished, String genre, int numberOfPages,
            double duration,
            String reader) {
        super(name, value, author, yearPublished, genre, numberOfPages);
        this.duration = duration;
        this.reader = reader;
    }

    public double getDuration() {
        return this.duration;
    }

    public String getReader() {
        return this.reader;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        AudioBook audioBook = (AudioBook) obj;
        return Double.compare(audioBook.duration, duration) == 0 &&
                Objects.equals(reader, audioBook.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, reader);
    }

    @Override
    public void stoppedAt(int progress) {
        if (progress >= 0 && progress <= duration * 60) {
            System.out.println("Stopped listening after " + progress + " minutes");
            System.out.println(((duration * 60) - progress) + "minutes left");
        } else {
            System.out.println("Invalid minutes listened provided");
        }
    }

    @Override
    public void getReadingStatus(int progress) {
        if (progress >= 0 && progress <= duration * 60) {
            String message = (progress == (int) (duration * 60)) ? "You are finished with the book!"
                    : (progress == 0) ? "You haven't even started to listen to the book."
                            : "You started listening but still not finished.";
            System.out.println(message);
        } else {
            System.out.println("Invalid minutes listened provided");
        }
    }

    @Override
    public void displayAllInformation() {
        super.displayAllInformation();
        System.out.println("Duration in hours: " + duration);
        System.out.println("Reader: " + reader);
    }

    @Override
    public void started() {
        System.out.println("Started listening an audio book.");
    }
}