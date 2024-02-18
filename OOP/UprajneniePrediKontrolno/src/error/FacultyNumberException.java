package error;

public class FacultyNumberException extends Exception{
    public FacultyNumberException() {
        super("Invalid faculty number - length must be between 5 and 10 symbols.");
    }
}
