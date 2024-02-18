package error;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
        super("Invalid year! Year must be between 1 and 9999.");
    }
}
