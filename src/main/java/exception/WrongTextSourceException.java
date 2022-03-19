package exception;

public class WrongTextSourceException extends Exception{
    @Override
    public String getMessage() {
        return "Wrong text's source";
    }
}
