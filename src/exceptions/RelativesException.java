package exceptions;

public class RelativesException extends Exception {
    public RelativesException() {
    }

    public RelativesException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "[CUSTOMEXCEPTION]" + super.getMessage();
    }
}
