package error;

public class FirstNameLengthException extends Exception{
    public FirstNameLengthException() {
        super("Invalid name - expected length at least 4 symbols.");
    }
}
