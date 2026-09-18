package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;
import aviation.model.Airport;
import aviation.model.Flight;
import aviation.model.FlightStatus;

public class FlightTest {

    public static void main(String[] args) {

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

        Aircraft aircraft = new Aircraft(
                "AC001",
                "A2-ABC",
                "Boeing 737-800",
                AircraftStatus.AVAILABLE,
                5436
        );

        Flight flight = new Flight(
                "AL101",
                harare,
                johannesburg,
                "08:00",
                "09:30",
                FlightStatus.SCHEDULED,
                aircraft
        );

        System.out.println(flight);
    }
}