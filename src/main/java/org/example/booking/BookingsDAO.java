package org.example.booking;

import java.io.*;
import java.util.ArrayList;


public class BookingsDAO implements BookingDao {
    private ArrayList<Booking> bookings;

    public BookingsDAO() {
        bookings = new ArrayList<>();
        loadAll();
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public void deleteBooking(int index) {
        bookings.remove(index);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBooking(Booking booking) {
        bookings.remove(booking);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBooking(Booking booking) {
        bookings.add(booking);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAll() {
        try {
            FileInputStream fis = new FileInputStream("bookindDB.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookings = (ArrayList<Booking>)ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void save() throws IOException {

        FileOutputStream fos = new FileOutputStream("bookindDB.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(bookings);
        oos.close();
    }
}
