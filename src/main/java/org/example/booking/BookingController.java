package org.example.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BookingController {
    BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }
    public List<Booking> getBookingOfUser(String login){
        return  service.getBookingOfUser(login);

    }
    public void addBooking(Booking booking){
        service.addBooking(booking);
    }
    public void deleteBooking(Booking booking){
        service.deleteBooking(booking);
    }
}
