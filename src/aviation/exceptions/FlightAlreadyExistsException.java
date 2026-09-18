package aviation.exceptions;

public class FlightAlreadyExistsException extends Exception {

    public FlightAlreadyExistsException(String message) {
        super(message);
    }
}