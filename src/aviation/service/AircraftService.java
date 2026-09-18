package aviation.service;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Flight;
import java.util.ArrayList;
import java.util.List;
import aviation.exceptions.AircraftNotFoundException;
import aviation.exceptions.InvalidAircraftException;
import aviation.exceptions.AircraftUnavailableException;

public class AircraftService {

    private List<Aircraft> aircraftList;

    public AircraftService() {
        aircraftList = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft)
            throws InvalidAircraftException {

        if (aircraft == null ||
            aircraft.getAircraftId() == null ||
            aircraft.getAircraftId().isEmpty() ||
            aircraft.getRegistrationId() == null ||
            aircraft.getRegistrationId().isEmpty() ||
            aircraft.getModel() == null ||
            aircraft.getModel().isEmpty() ||
            aircraft.getRange() <= 0 ||
            aircraft.getStatus() == null) {

            throw new InvalidAircraftException(
                    "Invalid aircraft details."
            );
        }

        aircraftList.add(aircraft);
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftList;
    }

    public Aircraft findAircraft(String aircraftId)
            throws AircraftNotFoundException {

        for (Aircraft aircraft : aircraftList) {

            if (aircraft.getAircraftId().equals(aircraftId)) {
                return aircraft;
            }
        }

        throw new AircraftNotFoundException(
                "Aircraft " + aircraftId + " not found."
        );
    }

    public void removeAircraft(String aircraftId)
            throws AircraftNotFoundException {

        Aircraft aircraft = findAircraft(aircraftId);

        aircraftList.remove(aircraft);
    }

    public void updateAircraftStatus(String aircraftId,
                                     AircraftStatus status)
            throws AircraftNotFoundException {

        Aircraft aircraft = findAircraft(aircraftId);

        aircraft.setStatus(status);
    }

    public void assignAircraftToFlight(String aircraftId,
                                       Flight flight)
            throws AircraftNotFoundException,
                   AircraftUnavailableException {

        Aircraft aircraft = findAircraft(aircraftId);

        if (aircraft.getStatus() != AircraftStatus.AVAILABLE) {

            throw new AircraftUnavailableException(
                    "Aircraft " + aircraftId
                    + " is not available."
            );
        }

        flight.setAircraft(aircraft);
        aircraft.setStatus(AircraftStatus.ASSIGNED);
    }

    public List<Aircraft> getAvailableAircraft() {

        List<Aircraft> availableAircraft =
                new ArrayList<>();

        for (Aircraft aircraft : aircraftList) {

            if (aircraft.getStatus() == AircraftStatus.AVAILABLE) {
                availableAircraft.add(aircraft);
            }
        }

        return availableAircraft;
    }
}