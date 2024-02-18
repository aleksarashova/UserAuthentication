package error;


public class InvalidMonthException extends Exception {
    public InvalidMonthException() {
        super("Invalid month! Month must be between January and December.");
    }
}
