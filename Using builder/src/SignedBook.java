public class SignedBook extends Book {

    protected SignedBook(SignedBookBuilder builder) {
        super(builder);
    }

    @Override
    public double getValue() {
        return super.getValue() * 2;
    }

    public static class SignedBookBuilder extends Book.Builder<SignedBookBuilder> {

        public SignedBookBuilder(String name) {
            super(name);
        }

        @Override
        public SignedBook build() {
            return new SignedBook(this);
        }
    }
}
