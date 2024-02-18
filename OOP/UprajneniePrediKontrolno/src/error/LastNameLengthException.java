package error;

public class LastNameLengthException extends Exception{
    public LastNameLengthException() {
        super("Invalid name - expected length at least 3 symbols.");
    }
}
