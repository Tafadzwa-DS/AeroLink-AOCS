package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Airport;
import aviation.model.Flight;
import aviation.model.FlightStatus;
import aviation.model.Passenger;
import aviation.model.PassengerBooking;

import aviation.service.AircraftService;
import aviation.service.FlightService;
import aviation.service.PassengerService;
import aviation.service.BookingService;
import aviation.service.ReportService;

public class ServiceTest {

    public static void main(String[] args) {

        try {

            // SERVICES
            AircraftService aircraftService = new AircraftService();
            FlightService flightService = new FlightService();
            PassengerService passengerService = new PassengerService();
            BookingService bookingService = new BookingService();
            ReportService reportService = new ReportService();

            // AIRPORTS
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

            // AIRCRAFT
            Aircraft aircraft1 = new Aircraft(
                    "AC001",
                    "A2-ABC",
                    "Boeing 737-800",
                    AircraftStatus.AVAILABLE,
                    5436
            );

            Aircraft aircraft2 = new Aircraft(
                    "AC002",
                    "A2-DEF",
                    "Airbus A320",
                    AircraftStatus.MAINTENANCE,
                    6100
            );

            aircraftService.addAircraft(aircraft1);
            aircraftService.addAircraft(aircraft2);

            // FLIGHTS
            Flight flight1 = new Flight(
                    "AL101",
                    harare,
                    johannesburg,
                    "08:00",
                    "09:30",
                    FlightStatus.SCHEDULED,
                    aircraft1
            );

            Flight flight2 = new Flight(
                    "AL102",
                    johannesburg,
                    harare,
                    "11:00",
                    "12:30",
                    FlightStatus.DELAYED,
                    null
            );

            flightService.addFlight(flight1);
            flightService.addFlight(flight2);

            // PASSENGER
            Passenger passenger = new Passenger(
                    "P001",
                    "Tafadzwa",
                    "0712345678",
                    "password123",
                    "tafadzwa@example.com"
            );

            passengerService.registerPassenger(passenger);

            // BOOKINGS
            PassengerBooking booking1 = new PassengerBooking(
                    "B001",
                    passenger,
                    flight1,
                    "12A",
                    "CONFIRMED",
                    850.0
            );

            PassengerBooking booking2 = new PassengerBooking(
                    "B002",
                    passenger,
                    flight1,
                    "12B",
                    "CONFIRMED",
                    850.0
            );

            bookingService.addBooking(booking1);
            bookingService.addBooking(booking2);

            // REPORTS
            System.out.println("=== AEROLINK SERVICE TEST ===");

            System.out.println(
                    "Total aircraft: "
                    + aircraftService.getAllAircraft().size()
            );

            System.out.println(
                    "Available aircraft: "
                    + reportService.countAvailableAircraft(
                            aircraftService)
            );

            System.out.println(
                    "Maintenance aircraft: "
                    + reportService.countMaintenanceAircraft(
                            aircraftService)
            );

            System.out.println(
                    "Total flights: "
                    + reportService.countFlights(flightService)
            );

            System.out.println(
                    "Delayed flights: "
                    + reportService.countDelayedFlights(
                            flightService)
            );

            System.out.println(
                    "Total passengers: "
                    + passengerService.getAllPassengers().size()
            );

            System.out.println(
                    "Total bookings: "
                    + reportService.countBookings(
                            bookingService)
            );

            System.out.println(
                    "Passengers on AL101: "
                    + reportService.countPassengersOnFlight(
                            bookingService,
                            "AL101")
            );

            System.out.println(
                    "Total revenue: P"
                    + reportService.calculateTotalRevenue(
                            bookingService)
            );

            System.out.println("=== TEST COMPLETE ===");

        } catch (Exception e) {

            System.out.println(
                    "Test failed: " + e.getMessage()
            );
        }
    }
}