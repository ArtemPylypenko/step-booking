package org.example.booking;

import java.util.ArrayList;

public interface BookingDao {
    public ArrayList<Booking> getAllBookings();
    public void deleteBooking(int index);
    public void addBooking(Booking booking);
}
