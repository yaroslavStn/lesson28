package myException;

public class StudentException extends Exception {
    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
