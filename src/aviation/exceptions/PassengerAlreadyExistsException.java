package aviation.exceptions;

public class PassengerAlreadyExistsException extends Exception {

    public PassengerAlreadyExistsException(String message) {
        super(message);
    }
}