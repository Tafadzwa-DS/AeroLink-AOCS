package aviation.service;

import aviation.model.Aircraft;
import aviation.model.Flight;
import aviation.model.FlightStatus;

import java.util.ArrayList;
import java.util.List;

import aviation.exceptions.FlightNotFoundException;
import aviation.exceptions.FlightAlreadyExistsException;
import aviation.exceptions.InvalidFlightException;

public class FlightService {

    private List<Flight> flightList;

    public FlightService() {
        flightList = new ArrayList<>();
    }

    public void addFlight(Flight flight)
            throws FlightAlreadyExistsException,
                   InvalidFlightException {

        if (flight == null ||
            flight.getFlightNumber() == null ||
            flight.getFlightNumber().isEmpty() ||
            flight.getOrigin() == null ||
            flight.getDestination() == null ||
            flight.getDepartureTime() == null ||
            flight.getDepartureTime().isEmpty() ||
            flight.getArrivalTime() == null ||
            flight.getArrivalTime().isEmpty() ||
            flight.getStatus() == null) {

            throw new InvalidFlightException(
                    "Invalid flight details."
            );
        }

        for (Flight existingFlight : flightList) {

            if (existingFlight.getFlightNumber()
                    .equals(flight.getFlightNumber())) {

                throw new FlightAlreadyExistsException(
                        "Flight " + flight.getFlightNumber()
                        + " already exists."
                );
            }
        }

        flightList.add(flight);
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }

    public Flight findFlight(String flightNumber)
            throws FlightNotFoundException {

        for (Flight flight : flightList) {

            if (flight.getFlightNumber()
                    .equals(flightNumber)) {

                return flight;
            }
        }

        throw new FlightNotFoundException(
                "Flight " + flightNumber + " not found."
        );
    }

    public void removeFlight(String flightNumber)
            throws FlightNotFoundException {

        Flight flight = findFlight(flightNumber);

        flightList.remove(flight);
    }

    public void updateFlightStatus(String flightNumber,
                                   FlightStatus status)
            throws FlightNotFoundException {

        Flight flight = findFlight(flightNumber);

        flight.setStatus(status);
    }

    public void cancelFlight(String flightNumber)
            throws FlightNotFoundException {

        Flight flight = findFlight(flightNumber);

        flight.setStatus(FlightStatus.CANCELLED);
    }

    public void delayFlight(String flightNumber)
            throws FlightNotFoundException {

        Flight flight = findFlight(flightNumber);

        flight.setStatus(FlightStatus.DELAYED);
    }

    public void setAircraftForFlight(String flightNumber,
                                     Aircraft aircraft)
            throws FlightNotFoundException {

        Flight flight = findFlight(flightNumber);

        flight.setAircraft(aircraft);
    }

    public List<Flight> getScheduledFlights() {

        List<Flight> scheduledFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.SCHEDULED) {
                scheduledFlights.add(flight);
            }
        }

        return scheduledFlights;
    }

    public List<Flight> getDelayedFlights() {

        List<Flight> delayedFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.DELAYED) {
                delayedFlights.add(flight);
            }
        }

        return delayedFlights;
    }

    public List<Flight> getCancelledFlights() {

        List<Flight> cancelledFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.CANCELLED) {
                cancelledFlights.add(flight);
            }
        }

        return cancelledFlights;
    }

    public List<Flight> getBoardingFlights() {

        List<Flight> boardingFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.BOARDING) {
                boardingFlights.add(flight);
            }
        }

        return boardingFlights;
    }

    public List<Flight> getDepartedFlights() {

        List<Flight> departedFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.DEPARTED) {
                departedFlights.add(flight);
            }
        }

        return departedFlights;
    }

    public List<Flight> getLandingFlights() {

        List<Flight> landingFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.LANDING) {
                landingFlights.add(flight);
            }
        }

        return landingFlights;
    }

    public List<Flight> getLandedFlights() {

        List<Flight> landedFlights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == FlightStatus.LANDED) {
                landedFlights.add(flight);
            }
        }

        return landedFlights;
    }

    public List<Flight> getFlightsByAircraft(String aircraftId) {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getAircraft() != null &&
                flight.getAircraft().getAircraftId()
                        .equals(aircraftId)) {

                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsByRoute(String originCode,
                                          String destinationCode) {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getOrigin().getAirportCode()
                        .equals(originCode)
                    && flight.getDestination().getAirportCode()
                        .equals(destinationCode)) {

                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsByStatus(FlightStatus status) {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getStatus() == status) {
                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsByOrigin(String originCode) {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getOrigin().getAirportCode()
                    .equals(originCode)) {

                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsByDestination(
            String destinationCode) {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getDestination().getAirportCode()
                    .equals(destinationCode)) {

                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsWithoutAircraft() {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getAircraft() == null) {
                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getFlightsWithAircraft() {

        List<Flight> flights = new ArrayList<>();

        for (Flight flight : flightList) {

            if (flight.getAircraft() != null) {
                flights.add(flight);
            }
        }

        return flights;
    }

    public int getFlightCountByStatus(FlightStatus status) {

        int count = 0;

        for (Flight flight : flightList) {

            if (flight.getStatus() == status) {
                count++;
            }
        }

        return count;
    }

    public int getFlightCountByRoute(String originCode,
                                     String destinationCode) {

        int count = 0;

        for (Flight flight : flightList) {

            if (flight.getOrigin().getAirportCode()
                        .equals(originCode)
                    && flight.getDestination().getAirportCode()
                        .equals(destinationCode)) {

                count++;
            }
        }

        return count;
    }

    public int getFlightCountByAircraft(String aircraftId) {

        int count = 0;

        for (Flight flight : flightList) {

            if (flight.getAircraft() != null &&
                flight.getAircraft().getAircraftId()
                        .equals(aircraftId)) {

                count++;
            }
        }

        return count;
    }
}