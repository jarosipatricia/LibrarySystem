// interface defining methods related to reading a book
//require all their methods to be implemented in classes that implement them
public interface Readable {
    void stoppedAt(int progress);

    void getReadingStatus(int progress);
}
