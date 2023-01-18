package org.example.booking;

import java.io.Serializable;

public class Booking implements Serializable {
    String userLogin;
    String placeTo;
    String date;
    int seatsBooked;

    public Booking(String userLogin, String placeTo, String date, int seatsBooked) {
        this.userLogin = userLogin;
        this.placeTo = placeTo;
        this.date = date;
        this.seatsBooked = seatsBooked;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public String getDate() {
        return date;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userLogin='" + userLogin + '\'' +
                ", placeTo='" + placeTo + '\'' +
                ", date='" + date + '\'' +
                ", seatsBooked=" + seatsBooked +
                '}';
    }
}
