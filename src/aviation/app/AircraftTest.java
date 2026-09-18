package aviation.app;

import aviation.model.Aircraft;
import aviation.model.AircraftStatus;

public class AircraftTest {

    public static void main(String[] args) {

        Aircraft aircraft1 = new Aircraft(
                "AC001",
                "A2-ABC",
                "Boeing 737-800",
                AircraftStatus.AVAILABLE,
                5436
        );

        System.out.println(aircraft1);
    }
}