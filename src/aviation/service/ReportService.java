package aviation.service;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Flight;
import aviation.model.FlightStatus;
import aviation.model.PassengerBooking;

public class ReportService {

    public ReportService() {

    }

    public int countFlights(FlightService flightService) {

        return flightService.getAllFlights().size();
    }

    public int countAvailableAircraft(
            AircraftService aircraftService) {

        int count = 0;

        for (Aircraft aircraft : aircraftService.getAllAircraft()) {

            if (aircraft.getStatus() == AircraftStatus.AVAILABLE) {
                count++;
            }
        }

        return count;
    }

    public int countMaintenanceAircraft(
            AircraftService aircraftService) {

        int count = 0;

        for (Aircraft aircraft : aircraftService.getAllAircraft()) {

            if (aircraft.getStatus() == AircraftStatus.MAINTENANCE) {
                count++;
            }
        }

        return count;
    }

    public int countInFlightAircraft(
            AircraftService aircraftService) {

        int count = 0;

        for (Aircraft aircraft : aircraftService.getAllAircraft()) {

            if (aircraft.getStatus() == AircraftStatus.IN_FLIGHT) {
                count++;
            }
        }

        return count;
    }

    public int countDelayedFlights(
            FlightService flightService) {

        int count = 0;

        for (Flight flight : flightService.getAllFlights()) {

            if (flight.getStatus() == FlightStatus.DELAYED) {
                count++;
            }
        }

        return count;
    }

    public int countCancelledFlights(
            FlightService flightService) {

        int count = 0;

        for (Flight flight : flightService.getAllFlights()) {

            if (flight.getStatus() == FlightStatus.CANCELLED) {
                count++;
            }
        }

        return count;
    }

    public int countPassengersOnFlight(
            BookingService bookingService,
            String flightNumber) {

        return bookingService
                .getBookingsForFlight(flightNumber)
                .size();
    }

    public int countBookings(BookingService bookingService) {

        return bookingService.getAllBookings().size();
    }

    public double calculateTotalRevenue(
            BookingService bookingService) {

        double totalRevenue = 0.0;

        for (PassengerBooking booking :
                bookingService.getAllBookings()) {

            if (!booking.getBookingStatus().equals("CANCELLED")) {
                totalRevenue += booking.getFare();
            }
        }

        return totalRevenue;
    }
}