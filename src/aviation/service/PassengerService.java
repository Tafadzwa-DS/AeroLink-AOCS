package aviation.service;

import aviation.model.Passenger;
import java.util.ArrayList;
import java.util.List;
import aviation.exceptions.PassengerNotFoundException;
import aviation.exceptions.PassengerAlreadyExistsException;
import aviation.exceptions.InvalidPassengerException;

public class PassengerService {

    private List<Passenger> passengerList;

    public PassengerService() {
        passengerList = new ArrayList<>();
    }

    public void registerPassenger(Passenger passenger)
            throws PassengerAlreadyExistsException,
                   InvalidPassengerException {

        if (passenger == null ||
            passenger.getPassengerId() == null ||
            passenger.getPassengerId().isEmpty() ||
            passenger.getName() == null ||
            passenger.getName().isEmpty() ||
            passenger.getPhone() == null ||
            passenger.getPhone().isEmpty() ||
            passenger.getPassword() == null ||
            passenger.getPassword().isEmpty() ||
            passenger.getEmail() == null ||
            passenger.getEmail().isEmpty()) {

            throw new InvalidPassengerException(
                    "Invalid passenger details."
            );
        }

        for (Passenger existingPassenger : passengerList) {

            if (existingPassenger.getPassengerId()
                    .equals(passenger.getPassengerId())) {

                throw new PassengerAlreadyExistsException(
                        "Passenger " + passenger.getPassengerId()
                        + " already exists."
                );
            }
        }

        passengerList.add(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerList;
    }

    public Passenger findPassenger(String passengerId)
            throws PassengerNotFoundException {

        for (Passenger passenger : passengerList) {

            if (passenger.getPassengerId()
                    .equals(passengerId)) {

                return passenger;
            }
        }

        throw new PassengerNotFoundException(
                "Passenger " + passengerId + " not found."
        );
    }

    public void removePassenger(String passengerId)
            throws PassengerNotFoundException {

        Passenger passenger = findPassenger(passengerId);

        passengerList.remove(passenger);
    }

    public Passenger loginPassenger(String passengerId, String password)
            throws PassengerNotFoundException {

        Passenger passenger = findPassenger(passengerId);

        if (passenger.getPassword().equals(password)) {
            return passenger;
        }

        return null;
    }

    public void updatePassenger(String passengerId,
                                String name,
                                String phone,
                                String email)
            throws PassengerNotFoundException {

        Passenger passenger = findPassenger(passengerId);

        passenger.setName(name);
        passenger.setPhone(phone);
        passenger.setEmail(email);
    }
}