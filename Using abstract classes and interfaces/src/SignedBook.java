public class SignedBook extends Book implements Readable {
    private int numberOfPagesLeft;

    public SignedBook(String name, double value, String author, int yearPublished, String genre, int numberOfPages) {
        super(name, value * 2, author, yearPublished, genre, numberOfPages);
        this.numberOfPagesLeft = numberOfPages;
    }

    @Override
    public void stoppedAt(int progress) {
        if (progress > 0 && progress <= getNumberOfPages()) {
            numberOfPagesLeft = getNumberOfPages() - progress;
            System.out.println("Stopped reading at page " + progress);
            System.out.println("Number of pages still left is " + numberOfPagesLeft);
        } else {
            System.out.println("Invalid page number was added");
        }
    }

    @Override
    public void getReadingStatus(int progress) {
        numberOfPagesLeft = getNumberOfPages() - progress;
        double percentage = ((double) progress / getNumberOfPages()) * 100;
        System.out.println("You have red " + percentage + "% of the book");
        System.out.println(numberOfPagesLeft + " number of pages are still waiting for you!");
    }

    @Override
    public void started() {
        System.out.println("Started reading a valuable signed book.");
    }
}
