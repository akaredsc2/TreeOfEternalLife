package exceptions;

public class RelativesException extends Exception {

    public RelativesException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "[CUSTOM_EXCEPTION]" + super.getMessage();
    }
}
