package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Airport;
import aviation.model.Flight;
import aviation.model.FlightStatus;
import aviation.service.AircraftService;

public class AircraftServiceTest {

    public static void main(String[] args) {

        AircraftService aircraftService = new AircraftService();

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
                AircraftStatus.AVAILABLE,
                6100
        );

        aircraftService.addAircraft(aircraft1);
        aircraftService.addAircraft(aircraft2);

        System.out.println("All Aircraft:");
        for (Aircraft aircraft : aircraftService.getAllAircraft()) {
            System.out.println(aircraft);
        }

        System.out.println("\nFind AC001:");
        System.out.println(aircraftService.findAircraft("AC001"));

        aircraftService.updateAircraftStatus(
                "AC001",
                AircraftStatus.MAINTENANCE
        );

        System.out.println("\nAfter status update:");
        System.out.println(aircraftService.findAircraft("AC001"));

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

        Flight flight = new Flight(
                "AL101",
                harare,
                johannesburg,
                "08:00",
                "09:30",
                FlightStatus.SCHEDULED,
                null
        );

        aircraftService.assignAircraftToFlight("AC002", flight);

        System.out.println("\nFlight after aircraft assignment:");
        System.out.println(flight);

        System.out.println("\nAC002 status:");
        System.out.println(aircraftService.findAircraft("AC002").getStatus());
    }
}