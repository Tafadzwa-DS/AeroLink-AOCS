package aviation.model;

public class PassengerBooking {

    private String bookingId;
    private Passenger passenger;
    private Flight flight;
    private String seatNumber;
    private String bookingStatus;
    private double fare;

    public PassengerBooking(String bookingId,
                            Passenger passenger,
                            Flight flight,
                            String seatNumber,
                            String bookingStatus,
                            double fare) {

        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.bookingStatus = bookingStatus;
        this.fare = fare;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public double getFare() {
        return fare;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "PassengerBooking{" +
                "bookingId=" + bookingId +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", seatNumber=" + seatNumber +
                ", bookingStatus=" + bookingStatus +
                ", fare=" + fare +
                '}';
    }
}