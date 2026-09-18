package aviation.exceptions;

public class BookingAlreadyExistsException extends Exception {

    public BookingAlreadyExistsException(String message) {
        super(message);
    }
}