package exception;

public class NullTextSourceException extends Exception{
    @Override
    public String getMessage() {
        return "One of text sources is null";
    }
}
