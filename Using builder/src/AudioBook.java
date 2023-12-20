public class AudioBook extends Book {
    private final double duration;
    private final String reader;

    private AudioBook(AudioBookBuilder builder) {
        super(builder);
        this.duration = builder.duration;
        this.reader = builder.reader;
    }

    public double getDuration() {
        return duration;
    }

    public String getReader() {
        return reader;
    }

    public static class AudioBookBuilder extends Book.Builder<AudioBookBuilder> {
        private double duration;
        private String reader;

        public AudioBookBuilder(String name) {
            super(name);
        }

        @Override
        protected AudioBookBuilder self() {
            return this;
        }

        public AudioBookBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public AudioBookBuilder setReader(String reader) {
            this.reader = reader;
            return this;
        }

        @Override
        public AudioBook build() {
            return new AudioBook(this);
        }
    }
}