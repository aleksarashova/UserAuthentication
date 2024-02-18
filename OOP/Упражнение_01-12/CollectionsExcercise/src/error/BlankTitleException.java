package error;

public class BlankTitleException extends Exception {
    public BlankTitleException() {
        super("Title cannot be blank!");
    }
}
