package exception;

public class UnsupportedComponentException extends Exception {
    @Override
    public String getMessage() {
        return "UNSUPPORTED COMPONENT";
    }

    @Override
    public void printStackTrace() {
        System.out.println(getMessage());
    }
}
