package org.example.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BookingController {
    BookingsDAO dao;

    public BookingController(BookingsDAO dao) {
        this.dao = dao;
    }
    public List<Booking> getBookingOfUser(String login){
        return  dao.getAllBookings()
                .stream().filter(booking -> booking.getUserLogin().equals(login)).toList();

    }
    public void addBooking(Booking booking){
        dao.addBooking(booking);
    }
    public void deleteBooking(Booking booking){
        dao.deleteBooking(booking);
    }
}
