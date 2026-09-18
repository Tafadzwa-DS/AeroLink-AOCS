package aviation.model;

public class Flight {

    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private String departureTime;
    private String arrivalTime;
    private FlightStatus status;
    private Aircraft aircraft;


    public Flight(String flightNumber, Airport origin, Airport destination, String departureTime,String arrivalTime, FlightStatus status, Aircraft aircraft) {

        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.aircraft = aircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }


    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
 
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override 
    public String toString() {
        return "Flight{" + 
                "flightNumber=" + flightNumber + 
                ", origin=" + origin +
                ", destination=" + destination +
                ", departureTime=" + arrivalTime +
                ", status=" + status +
                ", aircraft=" + aircraft + 
                '}';
    }

}