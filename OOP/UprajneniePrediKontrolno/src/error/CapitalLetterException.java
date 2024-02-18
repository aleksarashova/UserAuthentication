package error;

public class CapitalLetterException extends Exception{
    public CapitalLetterException() {
        super("Invalid name - must start with upper case letter.");
    }
}
