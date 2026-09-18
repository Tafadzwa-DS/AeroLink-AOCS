package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Airport;
import aviation.model.Flight;
import aviation.model.FlightStatus;
import aviation.model.Passenger;
import aviation.model.PassengerBooking;
import aviation.service.AircraftService;
import aviation.service.BookingService;
import aviation.service.FlightService;
import aviation.service.ReportService;

public class ReportServiceTest {

    public static void main(String[] args) {

        AircraftService aircraftService = new AircraftService();
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();
        ReportService reportService = new ReportService();

        Aircraft aircraft1 = new Aircraft(
                "AC001",
                "A2-ABC",
                "Boeing 737-800",
                AircraftStatus.AVAILABLE,
                5436
        );

        Aircraft aircraft2 = new Aircraft(
                "AC002",
                "A2-XYZ",
                "Airbus A320",
                AircraftStatus.IN_FLIGHT,
                6100
        );

        Aircraft aircraft3 = new Aircraft(
                "AC003",
                "A2-MNT",
                "Boeing 737-800",
                AircraftStatus.MAINTENANCE,
                5436
        );

        aircraftService.addAircraft(aircraft1);
        aircraftService.addAircraft(aircraft2);
        aircraftService.addAircraft(aircraft3);

        Airport harare = new Airport(
                "HRE",
                "Robert Gabriel Mugabe International Airport",
                "Harare",
                "Zimbabwe"
        );

        Airport johannesburg = new Airport(
                "JNB",
                "O.R. Tambo International Airport",
                "Johannesburg",
                "South Africa"
        );

        Flight flight1 = new Flight(
                "AL101",
                harare,
                johannesburg,
                "08:00",
                "09:30",
                FlightStatus.DELAYED,
                aircraft1
        );

        Flight flight2 = new Flight(
                "AL102",
                johannesburg,
                harare,
                "14:00",
                "15:30",
                FlightStatus.CANCELLED,
                aircraft2
        );

        flightService.addFlight(flight1);
        flightService.addFlight(flight2);

        Passenger passenger1 = new Passenger(
                "P001",
                "Test Passenger",
                "71234567",
                "password123",
                "test@example.com"
        );

        PassengerBooking booking1 = new PassengerBooking(
                "B001",
                passenger1,
                flight1,
                "12A",
                "CONFIRMED",
                850.00
        );

        PassengerBooking booking2 = new PassengerBooking(
                "B002",
                passenger1,
                flight1,
                "12B",
                "CONFIRMED",
                850.00
        );

        PassengerBooking booking3 = new PassengerBooking(
                "B003",
                passenger1,
                flight2,
                "14C",
                "CANCELLED",
                950.00
        );

        bookingService.addBooking(booking1);
        bookingService.addBooking(booking2);
        bookingService.addBooking(booking3);

        System.out.println("Total flights: "
                + reportService.countFlights(flightService));

        System.out.println("Available aircraft: "
                + reportService.countAvailableAircraft(aircraftService));

        System.out.println("Aircraft in maintenance: "
                + reportService.countMaintenanceAircraft(aircraftService));

        System.out.println("Aircraft in flight: "
                + reportService.countInFlightAircraft(aircraftService));

        System.out.println("Delayed flights: "
                + reportService.countDelayedFlights(flightService));

        System.out.println("Cancelled flights: "
                + reportService.countCancelledFlights(flightService));

        System.out.println("Total bookings: "
                + reportService.countBookings(bookingService));

        System.out.println("Passengers on AL101: "
                + reportService.countPassengersOnFlight(
                        bookingService, "AL101"));

        System.out.println("Total revenue: P"
                + reportService.calculateTotalRevenue(bookingService));
    }
}