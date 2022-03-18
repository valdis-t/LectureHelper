package exception;

public class UnsupportedComponentException extends Exception {
    @Override
    public String getMessage() {
        return "Unsupported component";
    }
}
