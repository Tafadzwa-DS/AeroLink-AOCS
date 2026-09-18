package aviation.service;

import aviation.model.PassengerBooking;
import java.util.ArrayList;
import java.util.List;
import aviation.exceptions.BookingAlreadyExistsException;
import aviation.exceptions.BookingNotFoundException;
import aviation.exceptions.InvalidBookingException;
import aviation.exceptions.SeatAlreadyBookedException;

public class BookingService {

    private List<PassengerBooking> bookingList;

    public BookingService() {
        bookingList = new ArrayList<>();
    }

    public void addBooking(PassengerBooking booking)
            throws BookingAlreadyExistsException,
                   InvalidBookingException,
                   SeatAlreadyBookedException {

        if (booking == null ||
            booking.getBookingId() == null ||
            booking.getBookingId().isEmpty() ||
            booking.getPassenger() == null ||
            booking.getFlight() == null ||
            booking.getSeatNumber() == null ||
            booking.getSeatNumber().isEmpty()) {

            throw new InvalidBookingException(
                    "Invalid booking details."
            );
        }

        for (PassengerBooking existingBooking : bookingList) {

            if (existingBooking.getBookingId()
                    .equals(booking.getBookingId())) {

                throw new BookingAlreadyExistsException(
                        "Booking " + booking.getBookingId()
                        + " already exists."
                );
            }
        }

        for (PassengerBooking existingBooking : bookingList) {

            if (existingBooking.getFlight().getFlightNumber()
                    .equals(booking.getFlight().getFlightNumber())
                    && existingBooking.getSeatNumber()
                    .equals(booking.getSeatNumber())
                    && !existingBooking.getBookingStatus()
                    .equals("CANCELLED")) {

                throw new SeatAlreadyBookedException(
                        "Seat " + booking.getSeatNumber()
                        + " is already booked on flight "
                        + booking.getFlight().getFlightNumber() + "."
                );
            }
        }

        bookingList.add(booking);
    }

    public List<PassengerBooking> getAllBookings() {
        return bookingList;
    }

    public PassengerBooking findBooking(String bookingId)
            throws BookingNotFoundException {

        for (PassengerBooking booking : bookingList) {

            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }

        throw new BookingNotFoundException(
                "Booking " + bookingId + " not found."
        );
    }

    public void cancelBooking(String bookingId)
            throws BookingNotFoundException {

        PassengerBooking booking = findBooking(bookingId);

        booking.setBookingStatus("CANCELLED");
    }

    public double calculateFare(String bookingId, double baseFare)
            throws BookingNotFoundException {

        PassengerBooking booking = findBooking(bookingId);

        booking.setFare(baseFare);

        return baseFare;
    }

    public List<PassengerBooking> getPassengersBookings(
            String passengerId) {

        List<PassengerBooking> passengerBookings =
                new ArrayList<>();

        for (PassengerBooking booking : bookingList) {

            if (booking.getPassenger().getPassengerId()
                    .equals(passengerId)) {

                passengerBookings.add(booking);
            }
        }

        return passengerBookings;
    }

    public List<PassengerBooking> getBookingsForFlight(
            String flightNumber) {

        List<PassengerBooking> flightBookings =
                new ArrayList<>();

        for (PassengerBooking booking : bookingList) {

            if (booking.getFlight().getFlightNumber()
                    .equals(flightNumber)) {

                flightBookings.add(booking);
            }
        }

        return flightBookings;
    }
}