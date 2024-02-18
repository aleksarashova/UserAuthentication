package error;

public class InvalidYearAfterCalculationException extends Exception {
    public InvalidYearAfterCalculationException() {
        super("Error: invalid year after calculation!");
    }
}
