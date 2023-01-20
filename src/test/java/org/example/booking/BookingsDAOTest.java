package org.example.booking;

import org.example.users.User;
import org.example.users.UsersDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingsDAOTest {

    @Test
    void getAllBookings() {
        BookingsDAO dao = new BookingsDAO("testBookingDB.txt");
        Booking test1 = new Booking("test1","test1","test1",1);
        Booking test2 = new Booking("test2","test2","test2",2);
        dao.addBooking(test1);
        dao.addBooking(test2);
        assertEquals(test1.toString(),dao.getAllBookings().get(0).toString());
        assertEquals(test2.toString(),dao.getAllBookings().get(1).toString());
    }

    @Test
    void deleteBooking() {
        BookingsDAO dao = new BookingsDAO("testBookingDB.txt");
        Booking test1 = new Booking("test1","test1","test1",1);
        Booking test2 = new Booking("test2","test2","test2",2);
        dao.addBooking(test1);
        dao.addBooking(test2);
        assertEquals(test1.toString(),dao.getAllBookings().get(0).toString());
        assertEquals(test2.toString(),dao.getAllBookings().get(1).toString());
    }

    @Test
    void testDeleteBooking() {
        BookingsDAO dao = new BookingsDAO("testBookingDB.txt");
        Booking test1 = new Booking("test1","test1","test1",1);
        Booking test2 = new Booking("test2","test2","test2",2);
        dao.addBooking(test1);
        dao.addBooking(test2);
        assertEquals(test1.toString(),dao.getAllBookings().get(0).toString());
        assertEquals(test2.toString(),dao.getAllBookings().get(1).toString());
    }

    @Test
    void addBooking() {
        BookingsDAO dao = new BookingsDAO("testBookingDB.txt");
        Booking test1 = new Booking("test1","test1","test1",1);
        Booking test2 = new Booking("test2","test2","test2",2);
        dao.addBooking(test1);
        dao.addBooking(test2);
        assertEquals(test1.toString(),dao.getAllBookings().get(0).toString());
        assertEquals(test2.toString(),dao.getAllBookings().get(1).toString());
    }
}