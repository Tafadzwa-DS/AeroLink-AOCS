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

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AircraftService aircraftService = new AircraftService();
        FlightService flightService = new FlightService();
        PassengerService passengerService = new PassengerService();
        BookingService bookingService = new BookingService();
        ReportService reportService = new ReportService();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("        AEROLINK AOCS");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Admin");
            System.out.println("2. Passenger");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    adminMenu(
                            scanner,
                            aircraftService,
                            flightService,
                            bookingService,
                            reportService
                    );
                    break;

                case "2":
                    passengerMenu(
                            scanner,
                            passengerService,
                            flightService,
                            bookingService
                    );
                    break;

                case "3":
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for Choosing AeroLink AOCS.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // ==============================
    // ADMIN MENU
    // ==============================

    public static void adminMenu(
            Scanner scanner,
            AircraftService aircraftService,
            FlightService flightService,
            BookingService bookingService,
            ReportService reportService) {

        boolean adminRunning = true;

        while (adminRunning) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("          ADMIN MENU");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Manage Aircraft");
            System.out.println("2. Manage Flights");
            System.out.println("3. View Reports");
            System.out.println("4. Back to Main Menu");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    aircraftMenu(scanner, aircraftService);
                    break;

                case "2":
                    flightMenu(
                            scanner,
                            aircraftService,
                            flightService
                    );
                    break;

                case "3":
                    reportMenu(
                            scanner,
                            aircraftService,
                            flightService,
                            bookingService,
                            reportService
                    );
                    break;

                case "4":
                    adminRunning = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ==============================
    // AIRCRAFT MENU
    // ==============================

    public static void aircraftMenu(
            Scanner scanner,
            AircraftService aircraftService) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       AIRCRAFT MANAGEMENT");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Add Aircraft");
            System.out.println("2. View All Aircraft");
            System.out.println("3. Find Aircraft");
            System.out.println("4. Remove Aircraft");
            System.out.println("5. Update Aircraft Status");
            System.out.println("6. View Available Aircraft");
            System.out.println("7. Back");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addAircraft(scanner, aircraftService);
                    break;

                case "2":
                    viewAllAircraft(aircraftService);
                    break;

                case "3":
                    findAircraft(scanner, aircraftService);
                    break;

                case "4":
                    removeAircraft(scanner, aircraftService);
                    break;

                case "5":
                    updateAircraftStatus(scanner, aircraftService);
                    break;

                case "6":
                    viewAvailableAircraft(aircraftService);
                    break;

                case "7":
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addAircraft(
            Scanner scanner,
            AircraftService aircraftService) {

        try {

            System.out.println();
            System.out.println("=== ADD AIRCRAFT ===");

            System.out.print("Aircraft ID: ");
            String aircraftId = scanner.nextLine();

            System.out.print("Registration ID: ");
            String registrationId = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Range (km): ");
            double range = Double.parseDouble(scanner.nextLine());

            Aircraft aircraft = new Aircraft(
                    aircraftId,
                    registrationId,
                    model,
                    AircraftStatus.AVAILABLE,
                    range
            );

            aircraftService.addAircraft(aircraft);

            System.out.println();
            System.out.println("Aircraft added successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewAllAircraft(
            AircraftService aircraftService) {

        System.out.println();
        System.out.println("=== ALL AIRCRAFT ===");

        List<Aircraft> aircraftList =
                aircraftService.getAllAircraft();

        if (aircraftList.isEmpty()) {

            System.out.println("No aircraft found.");
            return;
        }

        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft);
        }
    }

    public static void findAircraft(
            Scanner scanner,
            AircraftService aircraftService) {

        try {

            System.out.println();
            System.out.print("Enter aircraft ID: ");

            String aircraftId = scanner.nextLine();

            Aircraft aircraft =
                    aircraftService.findAircraft(aircraftId);

            System.out.println();
            System.out.println(aircraft);

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeAircraft(
            Scanner scanner,
            AircraftService aircraftService) {

        try {

            System.out.println();
            System.out.print("Enter aircraft ID: ");

            String aircraftId = scanner.nextLine();

            aircraftService.removeAircraft(aircraftId);

            System.out.println();
            System.out.println("Aircraft removed successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateAircraftStatus(
            Scanner scanner,
            AircraftService aircraftService) {

        try {

            System.out.println();
            System.out.print("Enter aircraft ID: ");

            String aircraftId = scanner.nextLine();

            System.out.println();
            System.out.println("1. AVAILABLE");
            System.out.println("2. ASSIGNED");
            System.out.println("3. IN_FLIGHT");
            System.out.println("4. MAINTENANCE");
            System.out.println();

            System.out.print("Select status: ");

            String choice = scanner.nextLine();

            AircraftStatus status;

            switch (choice) {

                case "1":
                    status = AircraftStatus.AVAILABLE;
                    break;

                case "2":
                    status = AircraftStatus.ASSIGNED;
                    break;

                case "3":
                    status = AircraftStatus.IN_FLIGHT;
                    break;

                case "4":
                    status = AircraftStatus.MAINTENANCE;
                    break;

                default:
                    System.out.println("Invalid status.");
                    return;
            }

            aircraftService.updateAircraftStatus(
                    aircraftId,
                    status
            );

            System.out.println();
            System.out.println("Aircraft status updated successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewAvailableAircraft(
            AircraftService aircraftService) {

        System.out.println();
        System.out.println("=== AVAILABLE AIRCRAFT ===");

        List<Aircraft> availableAircraft =
                aircraftService.getAvailableAircraft();

        if (availableAircraft.isEmpty()) {

            System.out.println("No available aircraft.");
            return;
        }

        for (Aircraft aircraft : availableAircraft) {
            System.out.println(aircraft);
        }
    }

    // ==============================
    // FLIGHT MENU
    // ==============================

    public static void flightMenu(
            Scanner scanner,
            AircraftService aircraftService,
            FlightService flightService) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("        FLIGHT MANAGEMENT");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Find Flight");
            System.out.println("4. Remove Flight");
            System.out.println("5. Update Flight Status");
            System.out.println("6. Cancel Flight");
            System.out.println("7. Delay Flight");
            System.out.println("8. Assign Aircraft");
            System.out.println("9. Search Flights");
            System.out.println("10. Back");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addFlight(scanner, flightService);
                    break;

                case "2":
                    viewAllFlights(flightService);
                    break;

                case "3":
                    findFlight(scanner, flightService);
                    break;

                case "4":
                    removeFlight(scanner, flightService);
                    break;

                case "5":
                    updateFlightStatus(scanner, flightService);
                    break;

                case "6":
                    cancelFlight(scanner, flightService);
                    break;

                case "7":
                    delayFlight(scanner, flightService);
                    break;

                case "8":
                    assignAircraft(
                            scanner,
                            aircraftService,
                            flightService
                    );
                    break;

                case "9":
                    searchFlights(scanner, flightService);
                    break;

                case "10":
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addFlight(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.println("=== ADD FLIGHT ===");

            System.out.print("Flight Number: ");
            String flightNumber = scanner.nextLine();

            System.out.println();
            System.out.println("--- ORIGIN AIRPORT ---");

            System.out.print("Airport Code: ");
            String originCode = scanner.nextLine();

            System.out.print("Airport Name: ");
            String originName = scanner.nextLine();

            System.out.print("City: ");
            String originCity = scanner.nextLine();

            System.out.print("Country: ");
            String originCountry = scanner.nextLine();

            Airport origin = new Airport(
                    originCode,
                    originName,
                    originCity,
                    originCountry
            );

            System.out.println();
            System.out.println("--- DESTINATION AIRPORT ---");

            System.out.print("Airport Code: ");
            String destinationCode = scanner.nextLine();

            System.out.print("Airport Name: ");
            String destinationName = scanner.nextLine();

            System.out.print("City: ");
            String destinationCity = scanner.nextLine();

            System.out.print("Country: ");
            String destinationCountry = scanner.nextLine();

            Airport destination = new Airport(
                    destinationCode,
                    destinationName,
                    destinationCity,
                    destinationCountry
            );

            System.out.print("Departure Time: ");
            String departureTime = scanner.nextLine();

            System.out.print("Arrival Time: ");
            String arrivalTime = scanner.nextLine();

            Flight flight = new Flight(
                    flightNumber,
                    origin,
                    destination,
                    departureTime,
                    arrivalTime,
                    FlightStatus.SCHEDULED,
                    null
            );

            flightService.addFlight(flight);

            System.out.println();
            System.out.println("Flight added successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewAllFlights(
            FlightService flightService) {

        System.out.println();
        System.out.println("=== ALL FLIGHTS ===");

        List<Flight> flights =
                flightService.getAllFlights();

        if (flights.isEmpty()) {

            System.out.println("No flights found.");
            return;
        }

        displayFlights(flights);
    }

    public static void findFlight(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.print("Enter flight number: ");

            String flightNumber = scanner.nextLine();

            Flight flight =
                    flightService.findFlight(flightNumber);

            System.out.println();
            System.out.println(flight);

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void removeFlight(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.print("Enter flight number: ");

            String flightNumber = scanner.nextLine();

            flightService.removeFlight(flightNumber);

            System.out.println();
            System.out.println("Flight removed successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateFlightStatus(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.print("Enter flight number: ");

            String flightNumber = scanner.nextLine();

            System.out.println();
            System.out.println("1. SCHEDULED");
            System.out.println("2. BOARDING");
            System.out.println("3. DEPARTED");
            System.out.println("4. LANDING");
            System.out.println("5. LANDED");
            System.out.println("6. DELAYED");
            System.out.println("7. CANCELLED");
            System.out.println();

            System.out.print("Select status: ");

            String choice = scanner.nextLine();

            FlightStatus status;

            switch (choice) {

                case "1":
                    status = FlightStatus.SCHEDULED;
                    break;

                case "2":
                    status = FlightStatus.BOARDING;
                    break;

                case "3":
                    status = FlightStatus.DEPARTED;
                    break;

                case "4":
                    status = FlightStatus.LANDING;
                    break;

                case "5":
                    status = FlightStatus.LANDED;
                    break;

                case "6":
                    status = FlightStatus.DELAYED;
                    break;

                case "7":
                    status = FlightStatus.CANCELLED;
                    break;

                default:
                    System.out.println("Invalid status.");
                    return;
            }

            flightService.updateFlightStatus(
                    flightNumber,
                    status
            );

            System.out.println();
            System.out.println("Flight status updated successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cancelFlight(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.print("Enter flight number: ");

            String flightNumber = scanner.nextLine();

            flightService.cancelFlight(flightNumber);

            System.out.println();
            System.out.println("Flight cancelled successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void delayFlight(
            Scanner scanner,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.print("Enter flight number: ");

            String flightNumber = scanner.nextLine();

            flightService.delayFlight(flightNumber);

            System.out.println();
            System.out.println("Flight delayed successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void assignAircraft(
            Scanner scanner,
            AircraftService aircraftService,
            FlightService flightService) {

        try {

            System.out.println();
            System.out.println("=== ASSIGN AIRCRAFT ===");

            System.out.print("Flight Number: ");
            String flightNumber = scanner.nextLine();

            System.out.print("Aircraft ID: ");
            String aircraftId = scanner.nextLine();

            Flight flight =
                    flightService.findFlight(flightNumber);

            aircraftService.assignAircraftToFlight(
                    aircraftId,
                    flight
            );

            System.out.println();
            System.out.println("Aircraft assigned successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchFlights(
            Scanner scanner,
            FlightService flightService) {

        System.out.println();
        System.out.println("=== SEARCH FLIGHTS ===");
        System.out.println();
        System.out.println("1. By Route");
        System.out.println("2. By Origin");
        System.out.println("3. By Destination");
        System.out.println("4. By Status");
        System.out.println("5. By Aircraft");
        System.out.println();

        System.out.print("Enter choice: ");

        String choice = scanner.nextLine();

        List<Flight> results;

        try {

            switch (choice) {

                case "1":

                    System.out.print("Origin airport code: ");
                    String origin = scanner.nextLine();

                    System.out.print("Destination airport code: ");
                    String destination = scanner.nextLine();

                    results = flightService.getFlightsByRoute(
                            origin,
                            destination
                    );

                    displayFlights(results);
                    break;

                case "2":

                    System.out.print("Origin airport code: ");
                    origin = scanner.nextLine();

                    results =
                            flightService.getFlightsByOrigin(origin);

                    displayFlights(results);
                    break;

                case "3":

                    System.out.print("Destination airport code: ");
                    destination = scanner.nextLine();

                    results =
                            flightService.getFlightsByDestination(
                                    destination
                            );

                    displayFlights(results);
                    break;

                case "4":

                    System.out.println();
                    System.out.println("1. SCHEDULED");
                    System.out.println("2. BOARDING");
                    System.out.println("3. DEPARTED");
                    System.out.println("4. LANDING");
                    System.out.println("5. LANDED");
                    System.out.println("6. DELAYED");
                    System.out.println("7. CANCELLED");

                    System.out.print("Select status: ");

                    String statusChoice = scanner.nextLine();

                    FlightStatus status;

                    switch (statusChoice) {

                        case "1":
                            status = FlightStatus.SCHEDULED;
                            break;

                        case "2":
                            status = FlightStatus.BOARDING;
                            break;

                        case "3":
                            status = FlightStatus.DEPARTED;
                            break;

                        case "4":
                            status = FlightStatus.LANDING;
                            break;

                        case "5":
                            status = FlightStatus.LANDED;
                            break;

                        case "6":
                            status = FlightStatus.DELAYED;
                            break;

                        case "7":
                            status = FlightStatus.CANCELLED;
                            break;

                        default:
                            System.out.println("Invalid status.");
                            return;
                    }

                    results =
                            flightService.getFlightsByStatus(status);

                    displayFlights(results);
                    break;

                case "5":

                    System.out.print("Aircraft ID: ");
                    String aircraftId = scanner.nextLine();

                    results =
                            flightService.getFlightsByAircraft(
                                    aircraftId
                            );

                    displayFlights(results);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayFlights(
            List<Flight> flights) {

        System.out.println();

        if (flights.isEmpty()) {

            System.out.println("No flights found.");
            return;
        }

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // ==============================
    // REPORT MENU
    // ==============================

    public static void reportMenu(
            Scanner scanner,
            AircraftService aircraftService,
            FlightService flightService,
            BookingService bookingService,
            ReportService reportService) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("          REPORTS");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Flight Summary");
            System.out.println("2. Aircraft Summary");
            System.out.println("3. Booking Summary");
            System.out.println("4. Revenue Summary");
            System.out.println("5. Back");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    System.out.println();
                    System.out.println("=== FLIGHT SUMMARY ===");

                    System.out.println(
                            "Total flights: "
                            + reportService.countFlights(
                                    flightService
                            )
                    );

                    System.out.println(
                            "Delayed flights: "
                            + reportService.countDelayedFlights(
                                    flightService
                            )
                    );

                    System.out.println(
                            "Cancelled flights: "
                            + reportService.countCancelledFlights(
                                    flightService
                            )
                    );

                    break;

                case "2":

                    System.out.println();
                    System.out.println("=== AIRCRAFT SUMMARY ===");

                    System.out.println(
                            "Available aircraft: "
                            + reportService.countAvailableAircraft(
                                    aircraftService
                            )
                    );

                    System.out.println(
                            "Aircraft in maintenance: "
                            + reportService.countMaintenanceAircraft(
                                    aircraftService
                            )
                    );

                    System.out.println(
                            "Aircraft in flight: "
                            + reportService.countInFlightAircraft(
                                    aircraftService
                            )
                    );

                    break;

                case "3":

                    System.out.println();
                    System.out.println("=== BOOKING SUMMARY ===");

                    System.out.println(
                            "Total bookings: "
                            + reportService.countBookings(
                                    bookingService
                            )
                    );

                    break;

                case "4":

                    System.out.println();
                    System.out.println("=== REVENUE SUMMARY ===");

                    System.out.println(
                            "Total revenue: USD$"
                            + reportService.calculateTotalRevenue(
                                    bookingService
                            )
                    );

                    break;

                case "5":
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ==============================
    // PASSENGER MENU
    // ==============================

    public static void passengerMenu(
            Scanner scanner,
            PassengerService passengerService,
            FlightService flightService,
            BookingService bookingService) {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("        PASSENGER MENU");
            System.out.println("=================================");
            System.out.println();
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back to Main Menu");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    registerPassenger(
                            scanner,
                            passengerService
                    );
                    break;

                case "2":
                    loginPassenger(
                            scanner,
                            passengerService,
                            flightService,
                            bookingService
                    );
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void registerPassenger(
            Scanner scanner,
            PassengerService passengerService) {

        try {

            System.out.println();
            System.out.println("=== PASSENGER REGISTRATION ===");

            System.out.print("Passenger ID: ");
            String passengerId = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Phone: ");
            String phone = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            Passenger passenger = new Passenger(
                    passengerId,
                    name,
                    phone,
                    password,
                    email
            );

            passengerService.registerPassenger(passenger);

            System.out.println();
            System.out.println("Passenger registered successfully.");
            System.out.println(passenger);

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void loginPassenger(
            Scanner scanner,
            PassengerService passengerService,
            FlightService flightService,
            BookingService bookingService) {

        try {

            System.out.println();
            System.out.println("=== PASSENGER LOGIN ===");

            System.out.print("Passenger ID: ");
            String passengerId = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            Passenger passenger =
                    passengerService.loginPassenger(
                            passengerId,
                            password
                    );

            if (passenger == null) {

                System.out.println();
                System.out.println("Invalid password.");

            } else {

                System.out.println();
                System.out.println("Login successful.");
                System.out.println(
                        "Welcome, "
                        + passenger.getName()
                        + "!"
                );

                passengerDashboard(
                        scanner,
                        passenger,
                        flightService,
                        bookingService
                );
            }

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==============================
    // PASSENGER DASHBOARD
    // ==============================

    public static void passengerDashboard(
            Scanner scanner,
            Passenger passenger,
            FlightService flightService,
            BookingService bookingService) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       PASSENGER DASHBOARD");
            System.out.println("=================================");
            System.out.println();
            System.out.println("Welcome, " + passenger.getName() + "!");
            System.out.println();
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flights");
            System.out.println("3. Book Flight");
            System.out.println("4. View My Bookings");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Logout");
            System.out.println();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    viewPassengerFlights(flightService);
                    break;

                case "2":
                    passengerSearchFlights(
                            scanner,
                            flightService
                    );
                    break;

                case "3":
                    bookFlight(
                            scanner,
                            passenger,
                            flightService,
                            bookingService
                    );
                    break;

                case "4":
                    viewMyBookings(
                            passenger,
                            bookingService
                    );
                    break;

                case "5":
                    cancelMyBooking(
                            scanner,
                            passenger,
                            bookingService
                    );
                    break;

                case "6":
                    loggedIn = false;

                    System.out.println();
                    System.out.println("Logged out successfully.");

                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewPassengerFlights(
            FlightService flightService) {

        System.out.println();
        System.out.println("=== AVAILABLE FLIGHTS ===");

        List<Flight> flights =
                flightService.getAllFlights();

        if (flights.isEmpty()) {

            System.out.println("No flights are currently available.");
            return;
        }

        for (Flight flight : flights) {

            if (flight.getStatus() != FlightStatus.CANCELLED) {
                System.out.println(flight);
            }
        }
    }

    public static void passengerSearchFlights(
            Scanner scanner,
            FlightService flightService) {

        System.out.println();
        System.out.println("=== SEARCH FLIGHTS ===");
        System.out.println();
        System.out.println("1. By Route");
        System.out.println("2. By Origin");
        System.out.println("3. By Destination");
        System.out.println("4. By Status");
        System.out.println();

        System.out.print("Enter choice: ");

        String choice = scanner.nextLine();

        try {

            List<Flight> results;

            switch (choice) {

                case "1":

                    System.out.print("Origin airport code: ");
                    String origin = scanner.nextLine();

                    System.out.print("Destination airport code: ");
                    String destination = scanner.nextLine();

                    results = flightService.getFlightsByRoute(
                            origin,
                            destination
                    );

                    displayFlights(results);
                    break;

                case "2":

                    System.out.print("Origin airport code: ");
                    origin = scanner.nextLine();

                    results =
                            flightService.getFlightsByOrigin(origin);

                    displayFlights(results);
                    break;

                case "3":

                    System.out.print("Destination airport code: ");
                    destination = scanner.nextLine();

                    results =
                            flightService.getFlightsByDestination(
                                    destination
                            );

                    displayFlights(results);
                    break;

                case "4":

                    System.out.println();
                    System.out.println("1. SCHEDULED");
                    System.out.println("2. BOARDING");
                    System.out.println("3. DEPARTED");
                    System.out.println("4. LANDING");
                    System.out.println("5. LANDED");
                    System.out.println("6. DELAYED");

                    System.out.print("Select status: ");

                    String statusChoice = scanner.nextLine();

                    FlightStatus status;

                    switch (statusChoice) {

                        case "1":
                            status = FlightStatus.SCHEDULED;
                            break;

                        case "2":
                            status = FlightStatus.BOARDING;
                            break;

                        case "3":
                            status = FlightStatus.DEPARTED;
                            break;

                        case "4":
                            status = FlightStatus.LANDING;
                            break;

                        case "5":
                            status = FlightStatus.LANDED;
                            break;

                        case "6":
                            status = FlightStatus.DELAYED;
                            break;

                        default:
                            System.out.println("Invalid status.");
                            return;
                    }

                    results =
                            flightService.getFlightsByStatus(status);

                    displayFlights(results);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ==============================
    // BOOK FLIGHT
    // ==============================

    public static void bookFlight(
            Scanner scanner,
            Passenger passenger,
            FlightService flightService,
            BookingService bookingService) {

        try {

            System.out.println();
            System.out.println("=== BOOK FLIGHT ===");

            System.out.print("Flight Number: ");
            String flightNumber = scanner.nextLine();

            Flight flight =
                    flightService.findFlight(flightNumber);

            if (flight.getStatus() == FlightStatus.CANCELLED) {

                System.out.println();
                System.out.println(
                        "This flight has been cancelled and cannot be booked."
                );

                return;
            }

            System.out.println();
            System.out.println("Selected flight:");
            System.out.println(flight);

            System.out.println();

            System.out.print("Booking ID: ");
            String bookingId = scanner.nextLine();

            System.out.print("Seat Number: ");
            String seatNumber = scanner.nextLine();

            System.out.print("Fare: USD$");
            double fare =
                    Double.parseDouble(scanner.nextLine());

            PassengerBooking booking =
                    new PassengerBooking(
                            bookingId,
                            passenger,
                            flight,
                            seatNumber,
                            "CONFIRMED",
                            fare
                    );

            bookingService.addBooking(booking);

            System.out.println();
            System.out.println("Booking successful.");
            System.out.println();
            System.out.println("Booking details:");
            System.out.println(booking);

        } catch (Exception e) {

            System.out.println();
            System.out.println("Booking failed: "
                    + e.getMessage());
        }
    }

    // ==============================
    // VIEW MY BOOKINGS
    // ==============================

    public static void viewMyBookings(
            Passenger passenger,
            BookingService bookingService) {

        System.out.println();
        System.out.println("=== MY BOOKINGS ===");

        List<PassengerBooking> bookings =
                bookingService.getPassengersBookings(
                        passenger.getPassengerId()
                );

        if (bookings.isEmpty()) {

            System.out.println("You have no bookings.");
            return;
        }

        for (PassengerBooking booking : bookings) {

            System.out.println();
            System.out.println(booking);
        }
    }

    // ==============================
    // CANCEL MY BOOKING
    // ==============================

    public static void cancelMyBooking(
            Scanner scanner,
            Passenger passenger,
            BookingService bookingService) {

        try {

            System.out.println();
            System.out.println("=== CANCEL BOOKING ===");

            System.out.print("Booking ID: ");
            String bookingId = scanner.nextLine();

            PassengerBooking booking =
                    bookingService.findBooking(bookingId);

            if (!booking.getPassenger().getPassengerId()
                    .equals(passenger.getPassengerId())) {

                System.out.println();
                System.out.println(
                        "You can only cancel your own bookings."
                );

                return;
            }

            if (booking.getBookingStatus()
                    .equals("CANCELLED")) {

                System.out.println();
                System.out.println(
                        "This booking is already cancelled."
                );

                return;
            }

            bookingService.cancelBooking(bookingId);

            System.out.println();
            System.out.println("Booking cancelled successfully.");

        } catch (Exception e) {

            System.out.println();
            System.out.println("Error: " + e.getMessage());
        }
    }
}