package error;

public class InvalidDayException extends Exception {
    public InvalidDayException() {
        super("Invalid day! Day must be between 1 and 28|29|30|31.");
    }
}
