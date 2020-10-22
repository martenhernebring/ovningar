public class ExceptionTrace {
    public static void doWrong() {
        throw new RuntimeException("Original Exception");
    }

    private static void callDoWrong() {
        try {
            doWrong();
        } catch (RuntimeException ex) {
            // throw new RuntimeException("Caught exception");
            throw new RuntimeException("Caught exception", ex);
        }
    }

    public static void main(String[] args) {
        callDoWrong();
    }
}