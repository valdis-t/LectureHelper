package exception;

public class NotInitialisedControllerException extends Exception {
    @Override
    public String getMessage() {
        return "Not initialised controller";
    }
}