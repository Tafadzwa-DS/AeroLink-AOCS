package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Airport;
import aviation.model.Flight;
import aviation.model.FlightStatus;
import aviation.service.FlightService;

public class FlightServiceTest {

    public static void main(String[] args) {

        FlightService flightService = new FlightService();

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

        Aircraft aircraft1 = new Aircraft(
                "AC001",
                "A2-ABC",
                "Boeing 737-800",
                AircraftStatus.AVAILABLE,
                5436
        );

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
                "14:00",
                "15:30",
                FlightStatus.DELAYED,
                null
        );

        flightService.addFlight(flight1);
        flightService.addFlight(flight2);

        System.out.println("Total flights: "
                + flightService.getAllFlights().size());

        System.out.println("Found flight: "
                + flightService.findFlight("AL101"));

        System.out.println("Scheduled flights: "
                + flightService.getScheduledFlights().size());

        System.out.println("Delayed flights: "
                + flightService.getDelayedFlights().size());

        System.out.println("HRE departures: "
                + flightService.getFlightsByOrigin("HRE").size());

        System.out.println("JNB arrivals: "
                + flightService.getFlightsByDestination("JNB").size());

        System.out.println("Flights without aircraft: "
                + flightService.getFlightsWithoutAircraft().size());

        System.out.println("Flights with aircraft: "
                + flightService.getFlightsWithAircraft().size());

        System.out.println("HRE to JNB flights: "
                + flightService.getFlightCountByRoute("HRE", "JNB"));

        System.out.println("Flights assigned to AC001: "
                + flightService.getFlightCountByAircraft("AC001"));

        System.out.println("Delayed flight count: "
                + flightService.getFlightCountByStatus(FlightStatus.DELAYED));
    }
}